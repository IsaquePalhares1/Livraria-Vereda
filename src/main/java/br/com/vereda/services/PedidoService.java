package br.com.vereda.services;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.vereda.repository.*;
import br.com.vereda.Endereco;
import br.com.vereda.Livro;
import br.com.vereda.Pedido;
import br.com.vereda.Usuario;
import br.com.vereda.dto.ItemPedidoRequestDTO;
import br.com.vereda.dto.PedidoRequestDTO;
import br.com.vereda.dto.PedidoResponseDTO;

/**
 * Regras de negócio relacionadas a pedidos.
 */
@Service
public class PedidoService {

    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final LivroRepository livroRepository;
    private final PedidoRepository pedidoRepository;

    PedidoService(UsuarioRepository usuarioRepository,
            EnderecoRepository enderecoRepository,
            LivroRepository livroRepository,
            PedidoRepository pedidoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoRepository = enderecoRepository;
        this.livroRepository = livroRepository;
        this.pedidoRepository = pedidoRepository;
    }

    /**
     * Cria um pedido com status {@code PENDENTE} e baixa o estoque dos livros.
     * O valor total e o preço de cada item vêm do preço cadastrado do livro.
     * Roda em uma única transação: se qualquer verificação falhar, nada é
     * gravado e o estoque volta ao que era.
     *
     * @param pedidoRequestDTO usuário, endereço de entrega e livros com suas
     *                         quantidades
     * @return o pedido criado, com seus itens
     * @throws ResponseStatusException 404 se o usuário, o endereço ou algum
     *                                 livro não existir; 400 se o endereço não
     *                                 for do usuário ou se faltar estoque
     */
    @Transactional
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {

        // 1- Definir Status do pedido como PENDENTE
        String status = "PENDENTE";

        // 2- Registrar data e horario da criacao do pedido
        LocalDateTime data_criacao = LocalDateTime.now();

        // 3 - Encontrar Usuario pelo Id +Exception
        Usuario usuario = usuarioRepository.findById(pedidoRequestDTO.usuarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        // 4- Encontrar Endereco (id) que pertença ao usuario (id_usuario) +Exception
        Endereco endereco = enderecoRepository.findById(pedidoRequestDTO.enderecoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));
        if (!endereco.getUsuario().getId().equals(usuario.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereço não pertence ao usuário");
        }

        // 5 - New Pedido(usuario, endereco, data_criacao, status, 0)
        Pedido pedido = new Pedido(usuario, endereco, data_criacao, status, BigDecimal.ZERO);

        // Laço percorrendo Lista de itens
        for (ItemPedidoRequestDTO i : pedidoRequestDTO.itens()) {
            // 6- Encontrar e verificar o livro desejado (id) + Exception
            Livro livro = livroRepository.findWithLockById(i.livroId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

            // 7- Ver a quantidade desejada e verificar o suporte do estoque +Exception
            if (i.quantidade() > livro.getQuantidade_estoque()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Quantidade solicitada excede o estoque disponível");
            }

            // 8 - Atualizar estoque do livro
            livro.setQuantidade_estoque(livro.getQuantidade_estoque() - i.quantidade());

            // 9- Atualizar valor da compra usando o preco pre definido
            BigDecimal valor_total = pedido.getValor_total()
                    .add(livro.getPreco().multiply(BigDecimal.valueOf(i.quantidade())));
            pedido.setValor_total(valor_total);

            // 10 - adicionar Item_Pedido
            pedido.adicionarItem(livro, i.quantidade(), livro.getPreco());

        }

        // 11- Registrar Pedido no Banco de Dados
        pedidoRepository.save(pedido);

        return new PedidoResponseDTO(pedido);
    }

}

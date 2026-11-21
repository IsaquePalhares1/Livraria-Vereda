package br.com.vereda.dto;

import br.com.vereda.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Dados de um pedido retornados pela API.
 *
 * @param id           identificador do pedido
 * @param status       situação atual do pedido
 * @param data_criacao data e hora em que o pedido foi criado
 * @param valor_total  valor total do pedido
 * @param itens        livros do pedido
 */
public record PedidoResponseDTO(

    Long id,
    String status,
    LocalDateTime data_criacao,
    BigDecimal valor_total,
    List<ItemPedidoResponseDTO> itens

) {

    /**
     * Converte a entidade {@link Pedido} em DTO, incluindo seus itens.
     *
     * @param pedido entidade de origem
     */
    public PedidoResponseDTO(Pedido pedido) {
        this(
            pedido.getId(),
            pedido.getStatus(),
            pedido.getData_criacao(),
            pedido.getValor_total(),
            pedido.getItens().stream()
                .map(ItemPedidoResponseDTO::new)
                .toList()
        );
    }
}

package br.com.vereda.dto;

import br.com.vereda.Item_pedido;

import java.math.BigDecimal;

/**
 * Item de um pedido retornado pela API.
 *
 * @param quantidade     quantidade do livro no pedido
 * @param preco_unitario preço do livro no momento da compra
 * @param livro          dados do livro
 */
public record ItemPedidoResponseDTO(

    Short quantidade,
    BigDecimal preco_unitario,
    LivroResumoDTO livro

) {

    /**
     * Converte a entidade {@link Item_pedido} em DTO.
     *
     * @param item entidade de origem
     */
    public ItemPedidoResponseDTO(Item_pedido item) {
        this(
            item.getQuantidade(),
            item.getPreco_unitario(),
            new LivroResumoDTO(item.getLivro())
        );
    }
}

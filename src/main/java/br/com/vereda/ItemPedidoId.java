package br.com.vereda;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Chave primária composta de {@link Item_pedido}, formada pelos ids
 * do pedido e livro.
 */
@Embeddable
public class ItemPedidoId implements Serializable {

    @Column(name = "pedido_id")
    private Long pedido_id;

    @Column(name = "livro_id")
    private Long livro_id;

    /** Construtor padrão exigido pelo JPA. */
    public ItemPedidoId() {

    }

    public ItemPedidoId(Long pedido_id, Long livro_id) {

        this.pedido_id = pedido_id;
        this.livro_id = livro_id;

    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    /**
     * Chaves compostas precisam de equals/hashCode baseados em todos os campos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ItemPedidoId itemPedidoId))
            return false;
        return Objects.equals(pedido_id, itemPedidoId.pedido_id)
                && Objects.equals(livro_id, itemPedidoId.livro_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido_id, livro_id);
    }

}

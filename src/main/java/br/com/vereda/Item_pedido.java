package br.com.vereda;

import java.util.Objects;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Entidade associativa entre {@link Pedido} e {@link Livro}.
 * Guarda a quantidade e o preço do livro no pedido.
 * Mapeada para a tabela {@code itens_pedido}.
 */
@Entity
@Table(name = "itens_pedido")
public class Item_pedido {

    /**
     * Chave composta (pedido_id + livro_id). Os valores são preenchidos
     * automaticamente a partir de {@code pedido} e {@code livro} via
     * {@code @MapsId}.
     */
    @EmbeddedId
    private ItemPedidoId id = new ItemPedidoId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pedido_id")
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("livro_id")
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    /** Quantidade do livro dentro do pedido. */
    @Column(name = "quantidade", nullable = false)
    private Short quantidade;

    /** Preço unitário do livro no pedido. */
    @Column(name = "preco_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco_unitario;

    /** Construtor padrão exigido pelo JPA. */
    public Item_pedido() {

    }

    /**
     * Associa um livro a um pedido.
     */

    public Item_pedido(Pedido pedido, Livro livro, Short quantidade,
            BigDecimal preco_unitario) {

        this.pedido = pedido;
        this.livro = livro;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }

    public ItemPedidoId getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(BigDecimal preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Item_pedido item_pedido))
            return false;
        return Objects.equals(id, item_pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

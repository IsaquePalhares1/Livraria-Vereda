package br.com.vereda;

import jakarta.persistence.*;

import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Entidade que representa um pedido da livraria.
 * Mapeada para a tabela {@code pedidos}.
 */
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime data_criacao;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor_total;

    /**
     * Os itens são salvos e removidos junto com o pedido (cascade + orphanRemoval).
     */
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item_pedido> itens = new ArrayList<>();

    /** Construtor padrão exigido pelo JPA. */
    public Pedido() {
    }

    /**
     * Cria um novo pedido sem id; o id é gerado pelo banco ao persistir.
     */
    public Pedido(Usuario usuario, Endereco endereco, LocalDateTime data_criacao, String status,
            BigDecimal valor_total) {
        this.usuario = usuario;
        this.endereco = endereco;
        this.data_criacao = data_criacao;
        this.status = status;
        this.valor_total = valor_total;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public List<Item_pedido> getItens() {
        return itens;
    }

    /**
     * Dois pedidos são iguais quando têm o mesmo id gerado pelo banco.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pedido pedido))
            return false;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Cria um item ligado a este pedido e o adiciona à lista de itens.
     * Se o livro já estiver no pedido, soma a quantidade ao item existente
     * em vez de criar outro (a chave de {@code itens_pedido} é pedido + livro).
     * O item é gravado em cascata quando o pedido for salvo.
     *
     * @param livro      livro comprado
     * @param quantidade quantidade do livro
     * @param preco      preço unitário do livro no momento da compra
     */
    public void adicionarItem(Livro livro, Short quantidade, BigDecimal preco) {
        
        for(Item_pedido item : itens) {
            if (item.getLivro().equals(livro)) {
               item.setQuantidade((short) (item.getQuantidade() + quantidade));
               return;
            }
        } 
        
        Item_pedido item = new Item_pedido(this, livro, quantidade, preco);
        itens.add(item);

    }

}

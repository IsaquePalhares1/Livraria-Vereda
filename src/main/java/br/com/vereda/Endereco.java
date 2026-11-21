package br.com.vereda;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;

/**
 * Entidade que representa um endereço de um usuário.
 * Mapeada para a tabela {@code enderecos}.
 */
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(length = 100)
    private String complemento;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String cidade;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(nullable = false, length = 2)
    private String estado;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(nullable = false, length = 8)
    private String cep;

    /** Construtor padrão exigido pelo JPA. */
    public Endereco() {

    }

    /**
     * Cria um novo endereço sem id; o id é gerado pelo banco ao persistir.
     */
    public Endereco(Usuario usuario, String logradouro, String numero, String complemento, String bairro, String cidade,
            String estado, String cep) {
        this.usuario = usuario;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    /**
     * Cria um novo endereço sem complemento; o id é gerado pelo banco ao persistir.
     */
    public Endereco(Usuario usuario, String logradouro, String numero, String bairro, String cidade, String estado,
            String cep) {
        this.usuario = usuario;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Dois endereços são iguais quando têm o mesmo id gerado pelo banco.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Endereco endereco))
            return false;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
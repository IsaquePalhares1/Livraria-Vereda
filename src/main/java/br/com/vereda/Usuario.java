package br.com.vereda;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Entidade que representa um usuário da livraria.
 * Mapeada para a tabela {@code usuarios}.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(length = 15)
    private String telefone;

    /** Construtor padrão exigido pelo JPA. */
    public Usuario() {

    }

    /**
     * Cria um novo usuário sem id; o id é gerado pelo banco ao persistir.
     */
    public Usuario(String nome, String email, String username, String senha) {
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.senha = senha;
    }

    /**
     * Cria um novo usuário com telefone; o id é gerado pelo banco ao persistir.
     */
    public Usuario(String nome, String email, String username, String senha, String telefone) {
        this(nome, email, username, senha);
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Dois usuários são iguais quando têm o mesmo id gerado pelo banco.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Usuario usuario))
            return false;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
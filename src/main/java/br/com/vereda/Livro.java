package br.com.vereda;

import java.time.LocalDate;
import jakarta.persistence.*;
import java.math.BigDecimal;


import java.util.Objects;


@Entity
@Table(name = "livros")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 50) 
    private String autor;

    @Column(nullable = false, length = 50) 
    private String genero;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Column(name = "data_publicacao")
    private LocalDate data_publicacao;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidade_estoque = 0;



public Livro(){

}

public Livro(String titulo, String autor, String genero, 
             String descricao, LocalDate data_publicacao, BigDecimal preco, 
             Integer quantidade_estoque){

    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.descricao = descricao;
    this.data_publicacao = data_publicacao;
    this.preco = preco;
    this.quantidade_estoque = quantidade_estoque;

}



public Long getId() {
    return id;
}


public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public String getGenero() {
    return genero;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public String getDescricao() {
    return descricao;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

public LocalDate getData_publicacao() {
    return data_publicacao;
}

public void setData_publicacao(LocalDate data_publicacao) {
    this.data_publicacao = data_publicacao;
}

public BigDecimal getPreco() {
    return preco;
}

public void setPreco(BigDecimal preco) {
    this.preco = preco;
}

public Integer getQuantidade_estoque() {
    return quantidade_estoque;
}

public void setQuantidade_estoque(Integer quantidade_estoque) {
    this.quantidade_estoque = quantidade_estoque;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Livro livro)) return false;
    return Objects.equals(id, livro.id);
}

@Override
 public int hashCode() {
    return Objects.hash(id);
}



}
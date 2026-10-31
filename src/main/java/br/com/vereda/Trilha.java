package br.com.vereda;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import jakarta.persistence.*;


/**
 * Entidade que representa uma trilha de leitura: uma sequência ordenada
 * de livros recomendados. Mapeada para a tabela {@code trilhas}.
 */
@Entity
@Table(name = "trilhas")
public class Trilha {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false, length = 100)
    private String nome;

     @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    /**
     * Livros da trilha, ordenados pelo campo {@code ordem}.
     * Os itens são salvos e removidos junto com a trilha (cascade + orphanRemoval).
     */
    @OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("ordem ASC")
    private List<Trilha_livro> itens = new ArrayList<>();


/** Construtor padrão exigido pelo JPA. */
public Trilha(){

}

/**
 * Cria uma nova trilha sem itens; o id é gerado pelo banco ao persistir.
 */
public Trilha(String nome, String descricao){

    this.nome = nome;
    this.descricao = descricao;
    
}


public Long getId() {
    return id;
}


public String getNome() {
    return nome;
}

public String getDescricao() {
    return descricao;
}

public List<Trilha_livro> getItens() {
    return itens;
}




public void setNome(String nome) {
    this.nome = nome;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}



/**
 * Duas trilhas são iguais quando têm o mesmo id gerado pelo banco.
 */
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Trilha trilha)) return false;
    return Objects.equals(id, trilha.id);
}

@Override
 public int hashCode() {
    return Objects.hash(id);
}


}


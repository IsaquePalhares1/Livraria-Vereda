package br.com.vereda;

import java.util.Objects;

import jakarta.persistence.*;

/**
 * Entidade associativa entre {@link Trilha} e {@link Livro}.
 * Guarda a posição do livro na trilha e o motivo da recomendação.
 * Mapeada para a tabela {@code trilhas_livros}.
 */
@Entity
@Table (name = "trilhas_livros")
public class Trilha_livro {
    
    /**
     * Chave composta (trilha_id + livro_id). Os valores são preenchidos
     * automaticamente a partir de {@code trilha} e {@code livro} via {@code @MapsId}.
     */
    @EmbeddedId
    private TrilhaLivroId id = new TrilhaLivroId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trilha_id")
    @JoinColumn(name = "trilha_id", nullable = false)
    private Trilha trilha;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("livro_id")
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    /** Posição do livro dentro da trilha. */
    @Column(name = "ordem", nullable = false)
    private Short ordem;

    /** Motivo de o livro fazer parte da trilha. */
    @Column (columnDefinition = "TEXT")
    private String justificativa;

    /** Construtor padrão exigido pelo JPA. */
    public Trilha_livro(){

    }

    /**
     * Associa um livro a uma trilha na posição indicada.
     */
    public Trilha_livro(Trilha trilha, Livro livro, Short ordem, String justificativa){

        this.trilha = trilha;
        this.livro = livro;
        this.ordem = ordem;
        this.justificativa = justificativa;
        
    }


    public TrilhaLivroId getId() {
    return id;
}

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Short getOrdem() {
        return ordem;
    }

    public void setOrdem(Short ordem) {
        this.ordem = ordem;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trilha_livro trilha_livro)) return false;
        return Objects.equals(id, trilha_livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}






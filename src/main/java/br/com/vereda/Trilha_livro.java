package br.com.vereda;

import java.util.Objects;

import jakarta.persistence.*;

@Entity 
@Table (name = "trilhas_livros")
public class Trilha_livro {
    
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

    @Column(name = "ordem", nullable = false)
    private Short ordem;

    @Column (columnDefinition = "TEXT")
    private String justificativa;

    public Trilha_livro(){

    }

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






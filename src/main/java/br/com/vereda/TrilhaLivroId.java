package br.com.vereda;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable 
public class TrilhaLivroId implements Serializable {

    @Column(name = "trilha_id")
    private Long trilha_id;

    @Column(name = "livro_id")
    private Long livro_id;
 
    


    public TrilhaLivroId(){

    }


    public TrilhaLivroId(Long trilha_id, Long livro_id){

        this.trilha_id = trilha_id;
        this.livro_id = livro_id;
        
    }


    


    public Long getTrilha_id() {
        return trilha_id;
    }


    public void setTrilha_id(Long trilha_id) {
        this.trilha_id = trilha_id;
    }


    public Long getLivro_id() {
        return livro_id;
    }


    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }


    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TrilhaLivroId trilhalivroid)) return false;
           return Objects.equals(trilha_id, trilhalivroid.trilha_id)
                              && Objects.equals(livro_id, trilhalivroid.livro_id);
        }

    @Override
        public int hashCode() {
            return Objects.hash(trilha_id, livro_id);
        }




}

package br.com.vereda.dto;


import br.com.vereda.Livro;
import java.math.BigDecimal;
import java.time.LocalDate;


public  record LivroResponseDTO(

    Long id,
    String titulo,
    String autor,
    String genero,
    String descricao,
    LocalDate data_publicacao,
    BigDecimal preco,
    Integer quantidade_estoque
) {

    public LivroResponseDTO(Livro livro){
        this(
            livro.getId(),
            livro.getTitulo(),
            livro.getAutor(),
            livro.getGenero(),
            livro.getDescricao(),
            livro.getData_publicacao(),
            livro.getPreco(),
            livro.getQuantidade_estoque()
        );
    }
}

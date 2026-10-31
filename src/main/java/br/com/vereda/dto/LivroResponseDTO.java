package br.com.vereda.dto;


import br.com.vereda.Livro;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Dados de um livro retornados pela API.
 *
 * @param id                 identificador do livro
 * @param titulo             título do livro
 * @param autor              nome do autor
 * @param genero             gênero literário
 * @param descricao          sinopse do livro
 * @param data_publicacao    data de publicação
 * @param preco              preço de venda
 * @param quantidade_estoque unidades disponíveis em estoque
 */
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

    /**
     * Converte a entidade {@link Livro} em DTO.
     *
     * @param livro entidade de origem
     */
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

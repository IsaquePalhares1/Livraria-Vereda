package br.com.vereda.dto;

import br.com.vereda.Livro;
import java.time.LocalDate;

/**
 * Versão resumida de um livro, usada quando ele aparece dentro de outro
 * recurso (item de pedido, item de trilha). Não expõe estoque nem preço atual.
 *
 * @param id                 identificador do livro
 * @param titulo             título do livro
 * @param autor              nome do autor
 * @param genero             gênero literário
 * @param data_publicacao   data de publicação
 */
public record LivroResumoDTO(

        Long id,
        String titulo,
        String autor,
        String genero,
        LocalDate data_publicacao) {

    /**
     * Converte a entidade {@link Livro} em DTO.
     *
     * @param livro entidade de origem
     */
    public LivroResumoDTO(Livro livro) {
        this(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getGenero(),
                livro.getData_publicacao());
    }
}

package br.com.vereda.dto;

import br.com.vereda.Trilha_livro;

/**
 * Livro dentro de uma trilha, retornado pela API.
 * Não referencia a trilha de volta, evitando recursão na serialização JSON.
 *
 * @param ordem         posição do livro na trilha
 * @param justificativa motivo de o livro fazer parte da trilha
 * @param livro         dados do livro
 */
public record TrilhaItemDTO(
    Short ordem,
    String justificativa,
    LivroResponseDTO livro
) {

    /**
     * Converte a entidade {@link Trilha_livro} em DTO.
     *
     * @param trilha_livro entidade de origem
     */
    public TrilhaItemDTO(Trilha_livro trilha_livro){
        this(
            trilha_livro.getOrdem(),
            trilha_livro.getJustificativa(),
            new LivroResponseDTO(trilha_livro.getLivro())
        );
    }

}

package br.com.vereda.dto;

import br.com.vereda.Trilha_livro;

public record TrilhaItemDTO(
    Short ordem,
    String justificativa,
    LivroResponseDTO livro
) {

    public TrilhaItemDTO(Trilha_livro trilha_livro){
        this(
            trilha_livro.getOrdem(),
            trilha_livro.getJustificativa(),
            new LivroResponseDTO(trilha_livro.getLivro())
        );
    }

}

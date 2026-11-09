package br.com.vereda.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Livro e quantidade informados ao criar um pedido.
 *
 * @param livroId    identificador do livro
 * @param quantidade quantidade desejada do livro
 */
public record ItemPedidoRequestDTO(

    @NotNull Long livroId,
    @NotNull @Positive Short quantidade

) {
}

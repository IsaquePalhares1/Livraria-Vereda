package br.com.vereda.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * Dados informados pelo cliente para criar um pedido.
 *
 * @param usuarioId  identificador do usuário que faz o pedido
 * @param enderecoId identificador do endereço de entrega
 * @param itens      livros do pedido, com suas quantidades
 */
public record PedidoRequestDTO(

    @NotNull Long usuarioId,
    @NotNull Long enderecoId,
    @NotEmpty List<@Valid ItemPedidoRequestDTO> itens

) {
}

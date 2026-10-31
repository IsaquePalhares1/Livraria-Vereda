package br.com.vereda.dto;


import br.com.vereda.Trilha;

import java.util.List;


/**
 * Dados de uma trilha de leitura retornados pela API.
 *
 * @param id        identificador da trilha
 * @param nome      nome da trilha
 * @param descricao descrição da trilha
 * @param itens     livros da trilha, na ordem de leitura
 */
public  record TrilhaResponseDTO(

    Long id,
    String nome,
    String descricao,
    List<TrilhaItemDTO> itens

) {

    /**
     * Converte a entidade {@link Trilha} em DTO, incluindo seus itens.
     *
     * @param trilha entidade de origem
     */
    public TrilhaResponseDTO(Trilha trilha){
        this(
            trilha.getId(),
            trilha.getNome(),
            trilha.getDescricao(),
            trilha.getItens().stream()
                .map(TrilhaItemDTO::new)
                .toList()
        );
    }
}
 
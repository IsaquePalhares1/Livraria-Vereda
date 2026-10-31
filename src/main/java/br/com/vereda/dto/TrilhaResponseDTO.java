package br.com.vereda.dto;


import br.com.vereda.Trilha;

import java.util.List;


public  record TrilhaResponseDTO(

    Long id,
    String nome,
    String descricao,
    List<TrilhaItemDTO> itens

) {

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
 
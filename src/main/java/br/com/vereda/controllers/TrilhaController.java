package br.com.vereda.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.com.vereda.dto.TrilhaResponseDTO;
import br.com.vereda.services.TrilhaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/trilhas") 
public class TrilhaController {

    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService){
        this.trilhaService = trilhaService;
    }

    @GetMapping
    public ResponseEntity<Page<TrilhaResponseDTO>> listar(
        @PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        
        Page<TrilhaResponseDTO> pagina = trilhaService.listarPaginado(paginacao);
        return ResponseEntity.ok(pagina);
    }
    

}

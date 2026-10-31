package br.com.vereda.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.com.vereda.dto.LivroResponseDTO;
import br.com.vereda.services.LivroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/livros") 
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<Page<LivroResponseDTO>> listar(
        @PageableDefault(size = 10, sort = "titulo") Pageable paginacao){
        
        Page<LivroResponseDTO> pagina = livroService.listarPaginado(paginacao);
        return ResponseEntity.ok(pagina);
    }
    

}

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

/**
 * Endpoints REST do catálogo de livros.
 */
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    /**
     * {@code GET /livros} — lista os livros paginados.
     * Padrão: 10 por página, ordenados por título.
     *
     * @param paginacao parâmetros {@code page}, {@code size} e {@code sort} da query string
     * @return 200 OK com a página de livros
     */
    @GetMapping
    public ResponseEntity<Page<LivroResponseDTO>> listar(
        @PageableDefault(size = 10, sort = "titulo") Pageable paginacao){
        
        Page<LivroResponseDTO> pagina = livroService.listarPaginado(paginacao);
        return ResponseEntity.ok(pagina);
    }
    

}

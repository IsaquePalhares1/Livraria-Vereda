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

/**
 * Endpoints REST das trilhas de leitura.
 */
@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService){
        this.trilhaService = trilhaService;
    }

    /**
     * {@code GET /trilhas} — lista as trilhas paginadas, com seus livros.
     * Padrão: 10 por página, ordenadas por nome.
     *
     * @param paginacao parâmetros {@code page}, {@code size} e {@code sort} da query string
     * @return 200 OK com a página de trilhas
     */
    @GetMapping
    public ResponseEntity<Page<TrilhaResponseDTO>> listar(
        @PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        
        Page<TrilhaResponseDTO> pagina = trilhaService.listarPaginado(paginacao);
        return ResponseEntity.ok(pagina);
    }
    

}

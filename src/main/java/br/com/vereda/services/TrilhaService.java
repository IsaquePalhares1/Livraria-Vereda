package br.com.vereda.services;

import org.springframework.stereotype.Service;

import br.com.vereda.dto.TrilhaResponseDTO;
import br.com.vereda.repository.TrilhaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Regras de negócio relacionadas a trilhas de leitura.
 */
@Service
    public class TrilhaService {

        private final TrilhaRepository trilhaRepository;

        public TrilhaService(TrilhaRepository trilhaRepository){
            this.trilhaRepository = trilhaRepository;
        }


        /**
         * Lista as trilhas de forma paginada, com seus livros.
         *
         * @param paginacao página, tamanho e ordenação desejados
         * @return página de trilhas convertidas em DTO
         */
        public Page<TrilhaResponseDTO> listarPaginado (Pageable paginacao){
            return trilhaRepository.findAll(paginacao).map(TrilhaResponseDTO::new);
        }

    }

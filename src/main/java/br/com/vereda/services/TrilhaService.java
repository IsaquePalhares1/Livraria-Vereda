package br.com.vereda.services;

import org.springframework.stereotype.Service;

import br.com.vereda.dto.TrilhaResponseDTO;
import br.com.vereda.repository.TrilhaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
    public class TrilhaService {

        private final TrilhaRepository trilhaRepository;

        public TrilhaService(TrilhaRepository trilhaRepository){
            this.trilhaRepository = trilhaRepository;
        }


        public Page<TrilhaResponseDTO> listarPaginado (Pageable paginacao){
            return trilhaRepository.findAll(paginacao).map(TrilhaResponseDTO::new);
        }

    }

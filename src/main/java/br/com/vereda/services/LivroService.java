package br.com.vereda.services;

import org.springframework.stereotype.Service;

import br.com.vereda.dto.LivroResponseDTO;
import br.com.vereda.repository.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
    public class LivroService {

        private final LivroRepository livroRepository;

        public LivroService(LivroRepository livroRepository){
            this.livroRepository = livroRepository;
        }


        public Page<LivroResponseDTO> listarPaginado (Pageable paginacao){
            return livroRepository.findAll(paginacao).map(LivroResponseDTO::new);
        }

    }

package br.com.vereda.repository;

import br.com.vereda.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de acesso aos dados de {@link Trilha}.
 * Os itens da trilha são persistidos em cascata, sem repositório próprio.
 */
public interface TrilhaRepository extends JpaRepository <Trilha, Long> {
    
}

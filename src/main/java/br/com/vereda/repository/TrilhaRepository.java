package br.com.vereda.repository;

import br.com.vereda.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrilhaRepository extends JpaRepository <Trilha, Long> {
    
}

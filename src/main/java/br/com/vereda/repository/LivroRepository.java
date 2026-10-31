package br.com.vereda.repository;

import br.com.vereda.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de acesso aos dados de {@link Livro}.
 * As operações básicas de CRUD e paginação vêm do {@link JpaRepository}.
 */
public interface LivroRepository extends JpaRepository <Livro, Long>  {
    
}

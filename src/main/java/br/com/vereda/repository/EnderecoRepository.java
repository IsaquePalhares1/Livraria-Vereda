package br.com.vereda.repository;

import br.com.vereda.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de acesso aos dados de {@link Endereco}.
 * As operações básicas de CRUD e paginação vêm do {@link JpaRepository}.
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}

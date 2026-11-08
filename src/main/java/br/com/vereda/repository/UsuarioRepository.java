package br.com.vereda.repository;

import br.com.vereda.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de acesso aos dados de {@link Usuario}.
 * As operações básicas de CRUD e paginação vêm do {@link JpaRepository}.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

package br.com.vereda.repository;

import br.com.vereda.Livro;
import jakarta.persistence.LockModeType;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;


/**
 * Repositório de acesso aos dados de {@link Livro}.
 * As operações básicas de CRUD e paginação vêm do {@link JpaRepository}.
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {

    //Trava para não ocorrer multiplos pedidos do mesmo livro ao mesmo tempo
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Livro> findWithLockById(Long id);

}

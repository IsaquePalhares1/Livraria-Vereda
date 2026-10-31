package br.com.vereda.repository;

import br.com.vereda.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long>  {
    
}

package br.com.vereda.repository;

import br.com.vereda.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de acesso aos dados de {@link Pedido}.
 * Os itens de Pedido são persistidos em cascata, sem repositório próprio.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
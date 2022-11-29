package br.com.rodrigoeduque.gerenciadorMultas.repository;

import br.com.rodrigoeduque.gerenciadorMultas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

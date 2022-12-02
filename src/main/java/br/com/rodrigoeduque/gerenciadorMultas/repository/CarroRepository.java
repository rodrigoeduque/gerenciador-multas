package br.com.rodrigoeduque.gerenciadorMultas.repository;

import br.com.rodrigoeduque.gerenciadorMultas.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}

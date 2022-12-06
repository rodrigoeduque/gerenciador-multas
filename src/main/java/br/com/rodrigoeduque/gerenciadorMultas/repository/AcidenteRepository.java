package br.com.rodrigoeduque.gerenciadorMultas.repository;

import br.com.rodrigoeduque.gerenciadorMultas.model.Acidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcidenteRepository extends JpaRepository<Acidente, Long> {
}

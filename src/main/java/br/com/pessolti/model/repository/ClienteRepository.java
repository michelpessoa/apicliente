package br.com.pessolti.model.repository;

import br.com.pessolti.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

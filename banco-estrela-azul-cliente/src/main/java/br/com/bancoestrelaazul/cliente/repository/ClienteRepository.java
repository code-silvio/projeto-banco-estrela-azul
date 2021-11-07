package br.com.bancoestrelaazul.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bancoestrelaazul.cliente.entity.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNumeroDaConta(final Long numeroDaConta);
}
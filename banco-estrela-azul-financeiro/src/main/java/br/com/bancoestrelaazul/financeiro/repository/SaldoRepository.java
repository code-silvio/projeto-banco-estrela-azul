package br.com.bancoestrelaazul.financeiro.repository;

import br.com.bancoestrelaazul.financeiro.entity.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Long> {

    Optional<Saldo> findByNumeroDaConta(Long numeroDaConta);
}

package br.com.bancoestrelaazul.financeiro.repository;

import br.com.bancoestrelaazul.financeiro.entity.Movimentacao;
import br.com.bancoestrelaazul.financeiro.entity.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    List<Movimentacao> findByNumeroDaConta(Long numeroDaConta);
}

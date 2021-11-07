package br.com.bancoestrelaazul.financeiro.service;

import br.com.bancoestrelaazul.financeiro.entity.Movimentacao;
import br.com.bancoestrelaazul.financeiro.entity.Saldo;
import br.com.bancoestrelaazul.financeiro.repository.MovimentacaoRepository;
import br.com.bancoestrelaazul.financeiro.repository.SaldoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    private MovimentacaoRepository repository;

    private MovimentacaoService(MovimentacaoRepository repository) {
        this.repository = repository;
    }

    public List<Movimentacao> getMovimentacaoByNumeroDaConta(Long numeroDaConta) {
        return repository.findByNumeroDaConta(numeroDaConta);
    }
}

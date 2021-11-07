package br.com.bancoestrelaazul.financeiro.service;

import br.com.bancoestrelaazul.financeiro.entity.Saldo;
import br.com.bancoestrelaazul.financeiro.repository.SaldoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {

    private SaldoRepository saldoRepository;

    private SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    public Optional<Saldo> getSaldoByNumeroDaConta(Long numeroDaConta) {
        return saldoRepository.findByNumeroDaConta(numeroDaConta);
    }

    public Saldo atualizar(Saldo saldo) {
        return saldoRepository.save(saldo);
    }

    public Saldo adicionar(Saldo novoSaldo) {
        return saldoRepository.save(novoSaldo);
    }

}

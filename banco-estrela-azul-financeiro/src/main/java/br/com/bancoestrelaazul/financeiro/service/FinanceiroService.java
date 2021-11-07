package br.com.bancoestrelaazul.financeiro.service;

import br.com.bancoestrelaazul.financeiro.entity.Saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FinanceiroService {
    
    private SaldoService saldoService;

    @Autowired
    public FinanceiroService(SaldoService saldoService){
        this.saldoService = saldoService;
    }

    public Saldo adicionarSaldo(Long numeroDaConta, BigDecimal valor) {

        Optional<Saldo> saldo = saldoService.getSaldoByNumeroDaConta(numeroDaConta);

        if(saldo.isPresent()){
            saldo.get().setSaldoAtual(valor);
            return saldoService.atualizar(saldo.get());
        }

        final Saldo novoSaldo = Saldo.builder().numeroDaConta(numeroDaConta).saldoAtual(valor)
                .dataAtualizacao(LocalDateTime.now()).build();
        return saldoService.adicionar(novoSaldo);
    }

    public Optional<Saldo> getSaldoByNumeroDaConta(Long numeroDaConta) {
        return saldoService.getSaldoByNumeroDaConta(numeroDaConta);
    }
}

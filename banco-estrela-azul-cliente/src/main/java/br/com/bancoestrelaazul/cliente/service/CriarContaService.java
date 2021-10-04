package br.com.bancoestrelaazul.cliente.service;

import br.com.bancoestrelaazul.cliente.entity.Cliente;
import br.com.bancoestrelaazul.financeiro.service.FinanceiroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
public class CriarContaService {

    private ClienteService clienteService;
    private FinanceiroService financeiroService;

    @Autowired
    public CriarContaService(ClienteService clienteService, FinanceiroService financeiroService) {
        this.clienteService = clienteService;
        this.financeiroService = financeiroService;
    }

    public void criarConta(Cliente cliente) {

        final Long numeroDaConta = System.currentTimeMillis();

        final Cliente novoCliente = buildCliente(cliente, numeroDaConta);

        clienteService.adicionar(novoCliente);

        financeiroService.adicionarSaldo(numeroDaConta, BigDecimal.ZERO);
    }

    private Cliente buildCliente(Cliente cliente, Long numeroDaConta) {
        return Cliente.builder()
                .ativo(true)
                .dataDeCadastro(LocalDateTime.now())
                .numeroDaConta(numeroDaConta)
                .nome(cliente.getNome())
                .endereco(cliente.getEndereco())
                .build();
    }
}

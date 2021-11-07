package br.com.bancoestrelaazul.web.service;

import br.com.bancoestrelaazul.cliente.entity.Cliente;
import br.com.bancoestrelaazul.cliente.service.ClienteService;
import br.com.bancoestrelaazul.financeiro.entity.Movimentacao;
import br.com.bancoestrelaazul.financeiro.entity.Saldo;
import br.com.bancoestrelaazul.financeiro.service.FinanceiroService;
import br.com.bancoestrelaazul.web.dto.Extrato;
import br.com.bancoestrelaazul.web.dto.HomeUsuario;
import br.com.bancoestrelaazul.web.dto.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class UsuarioService {

    private ClienteService clienteService;
    private FinanceiroService financeiroService;

    public UsuarioService(final ClienteService clienteService, final FinanceiroService financeiroService) {
        this.clienteService = clienteService;
        this.financeiroService = financeiroService;
    }

    public boolean isValid(Usuario usuario) {
        final Cliente pesquisarCliente = buildCliente(usuario);
        return clienteService.verificarCliente(pesquisarCliente);
    }

    private Cliente buildCliente(Usuario usuario) {
        return Cliente.builder()
                .numeroDaConta(Long.valueOf(usuario.getNumeroDaConta()))
                .senha(usuario.getSenha()).build();
    }

    public HomeUsuario buildHomeUsuario(Long conta) {
        Optional<Cliente> cliente = clienteService.findCliente(conta);
        Optional<Saldo> saldo = financeiroService.getSaldoByNumeroDaConta(conta);

        return HomeUsuario.builder()
                .numeroDaConta(cliente.get().getNumeroDaConta())
                .nome(cliente.get().getNome())
                .saldo(saldo.get().getSaldoAtual())
                .dataAtualizacao(saldo.get().getDataAtualizacao())
                .extratoList(buildExtrato(conta))
                .build();
    }

    private List<Extrato> buildExtrato(Long conta) {
        List<Movimentacao> movimentacaos = financeiroService.getMovimentacaoByNumeroDaConta(conta);

        if (movimentacaos.isEmpty()) {
            return Collections.emptyList();
        }

        List<Extrato> extratoList = new ArrayList<>();
        movimentacaos.forEach(m -> {
            extratoList.add(Extrato.builder()
                    .dataMovimento(m.getDataMovimento())
                    .tipoDeMovimento(m.getTipoDeMovimento())
                    .valor(m.getValor())
                    .build());
        });
        return extratoList;
    }
}

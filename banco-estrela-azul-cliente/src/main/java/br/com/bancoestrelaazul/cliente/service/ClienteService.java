package br.com.bancoestrelaazul.cliente.service;

import br.com.bancoestrelaazul.cliente.entity.Cliente;
import br.com.bancoestrelaazul.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(final ClienteRepository repository) {
        this.repository = repository;
    }

    public boolean verificarCliente(final Cliente pesquisarCliente) {
        Optional<Cliente> cliente = repository.findByNumeroDaConta(Long.valueOf(pesquisarCliente.getNumeroDaConta()));

        return cliente.isPresent()
                && cliente.get().getNumeroDaConta().equals(pesquisarCliente.getNumeroDaConta())
                && cliente.get().getSenha().equals(pesquisarCliente.getSenha());
    }

    public Optional<Cliente> findCliente(final Long cliente) {
        return repository.findByNumeroDaConta(Long.valueOf(cliente));
    }

    public Cliente adicionar(final Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizar(final Cliente cliente) {
        return Cliente.builder().build();
    }
}

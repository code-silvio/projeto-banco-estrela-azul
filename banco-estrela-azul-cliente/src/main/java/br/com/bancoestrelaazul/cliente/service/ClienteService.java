package br.com.bancoestrelaazul.cliente.service;

import br.com.bancoestrelaazul.cliente.entity.Cliente;
import br.com.bancoestrelaazul.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(final ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente adicionar(final Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizar(final Cliente cliente) {
        return Cliente.builder().build();
    }
}

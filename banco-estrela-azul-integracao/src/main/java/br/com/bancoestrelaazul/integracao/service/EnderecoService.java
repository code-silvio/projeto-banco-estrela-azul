package br.com.bancoestrelaazul.integracao.service;

import br.com.bancoestrelaazul.integracao.dto.EnderecoDTO;
import br.com.bancoestrelaazul.integracao.exception.IntegrationException;
import br.com.bancoestrelaazul.integracao.gateway.ViaCepClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EnderecoService {

    private ViaCepClient client;

    @Autowired
    public EnderecoService(ViaCepClient client) {
        this.client = client;
    }

    public EnderecoDTO getEnderecoByCep(final Integer cep) throws Exception {
        validaCep(String.valueOf(cep));

        log.info("Request cep: {}", cep);

        final EnderecoDTO dto = client.getEnderecoByCep(String.valueOf(cep));

        log.info("Response endereco: {}", dto);
        return dto;
    }

    private void validaCep(final String cep) throws Exception {
        if (cep.length() != 8) {
            throw new IntegrationException("Cep inválido");
        }
    }

}

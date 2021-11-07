package br.com.bancoestrelaazul.integracao;

import br.com.bancoestrelaazul.integracao.dto.EnderecoDTO;
import br.com.bancoestrelaazul.integracao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private EnderecoService service;

    @Autowired
    public Controller(EnderecoService service) {
        this.service = service;
    }

    @GetMapping("/integration/address/{cep}")
    EnderecoDTO getAddress(@PathVariable Integer cep) throws Exception {
        return service.getEnderecoByCep(cep);
    }

}

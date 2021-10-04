package br.com.bancoestrelaazul.integracao;

import br.com.bancoestrelaazul.integracao.dto.EnderecoDTO;
import br.com.bancoestrelaazul.integracao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private EnderecoService service;

    @Autowired
    public Controller(EnderecoService service) throws Exception {
       this.service = service;
    }

    @GetMapping("/gateway/test")
    EnderecoDTO get() throws Exception {
        return service.getEnderecoByCep("18117370");
    }

}

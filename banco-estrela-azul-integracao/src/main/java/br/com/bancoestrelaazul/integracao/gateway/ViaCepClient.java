package br.com.bancoestrelaazul.integracao.gateway;

import br.com.bancoestrelaazul.integracao.config.ViaCepFeignConfig;
import br.com.bancoestrelaazul.integracao.dto.EnderecoDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ConfigurationProperties(prefix = "integration")
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws", configuration = ViaCepFeignConfig.class)
public interface ViaCepClient {

    @GetMapping(value = "/{cep}/json/")
    EnderecoDTO getEnderecoByCep(@PathVariable String cep);
}

package br.com.bancoestrelaazul.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeUsuario {

    private Long numeroDaConta;
    private String nome;
    private BigDecimal saldo;
    private LocalDateTime dataAtualizacao;

}

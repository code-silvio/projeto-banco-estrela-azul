package br.com.bancoestrelaazul.web.dto;

import br.com.bancoestrelaazul.financeiro.entity.TipoDeMovimento;
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
public class Extrato {

    private BigDecimal valor;
    private TipoDeMovimento tipoDeMovimento;
    private LocalDateTime dataMovimento;

}

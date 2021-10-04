package br.com.bancoestrelaazul.financeiro.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity(name = "saldos")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private BigDecimal valor;

    @Column(name = "numero_conta")
    private Long numeroDaConta;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}

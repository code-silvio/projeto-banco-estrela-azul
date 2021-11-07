package br.com.bancoestrelaazul.financeiro.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "saldos")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saldo_atual")
    private BigDecimal saldoAtual;

    @Column(name = "numero_conta")
    private Long numeroDaConta;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}

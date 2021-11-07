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
@Entity(name = "movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_movimento")
    private TipoDeMovimento tipoDeMovimento;

    @Column(name = "data_movimento")
    private LocalDateTime dataMovimento;

    @Column(name = "numero_conta")
    private Long numeroDaConta;
}

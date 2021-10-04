package br.com.bancoestrelaazul.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "data_cadastro")
    private LocalDateTime dataDeCadastro;

    @Column(name = "numero_conta")
    private Long numeroDaConta;

    @Embedded
    private Endereco endereco;
}

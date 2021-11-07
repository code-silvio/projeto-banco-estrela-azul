package br.com.bancoestrelaazul.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "senha")
    private String senha;

    @Embedded
    private Endereco endereco;
}

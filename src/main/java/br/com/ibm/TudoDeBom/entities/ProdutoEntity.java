package br.com.ibm.TudoDeBom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date DataDeCriacao;
    private Boolean isMedicine;
    private Boolean isGeneric;
    private Integer estoque;
    @OneToOne(cascade = CascadeType.ALL)
    private EntradaEntity entrada;
    @OneToOne(cascade = CascadeType.ALL)
    private SaidaEntity saida;
}

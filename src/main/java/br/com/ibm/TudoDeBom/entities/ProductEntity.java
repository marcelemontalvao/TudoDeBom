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
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataDeCriacao;
    private Boolean isMedicine;
    private Boolean isGeneric;
    @OneToOne(cascade = CascadeType.ALL)
    private InputEntity entrada;
    @OneToOne(cascade = CascadeType.ALL)
    private OrderEntity saida;
}

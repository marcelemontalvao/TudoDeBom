package br.com.ibm.TudoDeBom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private Integer quantidade;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EntradaEntity> entrada;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SaidaEntity> saida;
}

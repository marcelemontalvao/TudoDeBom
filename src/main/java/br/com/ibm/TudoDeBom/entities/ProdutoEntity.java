package br.com.ibm.TudoDeBom.entities;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestSaidaDTO;
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
    @OneToOne(cascade = CascadeType.ALL)
    private EntradaEntity entrada;
    @OneToOne(cascade = CascadeType.ALL)
    private SaidaEntity saida;
}

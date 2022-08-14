package br.com.ibm.TudoDeBom.dto.response;

import br.com.ibm.TudoDeBom.entities.EntradaEntity;
import br.com.ibm.TudoDeBom.entities.SaidaEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ResponseProductDTO {
    private Long id;
    private String nome;
    private Date dataDeCriacao;
    private Boolean isMedicine;
    private Boolean isGeneric;
    private List<EntradaEntity> entrada;
    private List<SaidaEntity> saida;
}

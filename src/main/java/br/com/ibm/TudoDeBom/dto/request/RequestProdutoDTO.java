package br.com.ibm.TudoDeBom.dto.request;

import br.com.ibm.TudoDeBom.entities.EntradaEntity;
import br.com.ibm.TudoDeBom.entities.SaidaEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class RequestProdutoDTO {
    @NotEmpty
    private String nome;
    @DateTimeFormat
    private Date dataDeCriacao;
    @NotNull
    private Boolean isMedicine;
    @NotNull
    private Boolean isGeneric;

    private List<@Valid EntradaEntity> entrada;
    private List<@Valid SaidaEntity> saida;

}

package br.com.ibm.TudoDeBom.dto.request;

import br.com.ibm.TudoDeBom.entities.ProdutoEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class RequestSaidaDTO {
    @NotEmpty
    @DateTimeFormat
    private Date dataSaida;

    @ManyToOne
    private ProdutoEntity produto;
}

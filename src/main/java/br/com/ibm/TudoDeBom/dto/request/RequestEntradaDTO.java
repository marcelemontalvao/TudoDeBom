package br.com.ibm.TudoDeBom.dto.request;

import br.com.ibm.TudoDeBom.entities.ProdutoEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RequestEntradaDTO {
    @DateTimeFormat
    private Date dataEntrada;
    private BigDecimal precoUnitario;
    private Integer quantidadeEntrada;

    @ManyToOne
    private ProdutoEntity produto;
}

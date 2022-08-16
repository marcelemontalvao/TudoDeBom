package br.com.ibm.TudoDeBom.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RequestInputDTO {
    @DateTimeFormat
    private Date dataEntrada;
    @NotNull
    private Integer estoque;
}

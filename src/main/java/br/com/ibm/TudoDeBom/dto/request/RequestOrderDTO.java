package br.com.ibm.TudoDeBom.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RequestOrderDTO {
    @DateTimeFormat
    private Date dataSaida;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}

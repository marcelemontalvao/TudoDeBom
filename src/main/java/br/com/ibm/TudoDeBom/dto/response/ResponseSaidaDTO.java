package br.com.ibm.TudoDeBom.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ResponseSaidaDTO {

    private Long id;
    private Date dataSaida;
    private BigDecimal valorFinal;
}

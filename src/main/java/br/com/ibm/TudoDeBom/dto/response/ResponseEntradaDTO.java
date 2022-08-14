package br.com.ibm.TudoDeBom.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ResponseEntradaDTO {
    private Long id;
    private Date dataEntrada;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}

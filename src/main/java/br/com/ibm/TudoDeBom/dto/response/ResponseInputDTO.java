package br.com.ibm.TudoDeBom.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseInputDTO {
    private Long id;
    private Date dataEntrada;
    private Integer estoque;

}

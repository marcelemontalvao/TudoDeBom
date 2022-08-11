package br.com.ibm.TudoDeBom.entities.dto.response;

import lombok.Data;

@Data
public class ResponseProductDTO {
    private Long id;
    private String nome;
    private Double preco;
    private Integer estoque;
    private Double desconto;
}

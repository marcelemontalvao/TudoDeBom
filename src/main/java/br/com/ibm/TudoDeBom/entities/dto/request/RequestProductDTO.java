package br.com.ibm.TudoDeBom.entities.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RequestProductDTO {
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private Double preco;
    @NotNull
    @NotBlank
    private Integer estoque;
    @NotNull
    @NotBlank
    private Double desconto;
}

package br.com.ibm.TudoDeBom.dto.response;

import lombok.Data;

@Data
public class ResponseClientDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
}

package br.com.ibm.TudoDeBom.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class RequestSaidaDTO {
    @NotEmpty
    @DateTimeFormat
    private Date dataSaida;
}

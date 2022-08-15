package br.com.ibm.TudoDeBom.controller;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestSaidaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseSaidaDTO;
import br.com.ibm.TudoDeBom.repository.SaidaRepository;
import br.com.ibm.TudoDeBom.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/saidas")
public class SaidaController {

    @Autowired
    private SaidaService saidaService;

    @Autowired
    private SaidaRepository saidaRepository;

    @PostMapping() public ResponseEntity<ResponseSaidaDTO> post(@Valid @RequestBody RequestSaidaDTO requestSaidaDTO) {
        ResponseSaidaDTO responseSaidaDTO = saidaService.save(requestSaidaDTO);
        return ResponseEntity.ok(responseSaidaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseSaidaDTO>> getAll(ResponseSaidaDTO responseSaidaDTO) {
       List<ResponseSaidaDTO> responseSaidaDTOS = saidaService.getAll();
        return ResponseEntity.ok(responseSaidaDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSaidaDTO> getSaidaById(@PathVariable Long id) {
        ResponseSaidaDTO responseClienteDTO = saidaService.getById(id);
        return ResponseEntity.ok(responseClienteDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid RequestSaidaDTO request, @PathVariable Long id) {
        saidaService.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        saidaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

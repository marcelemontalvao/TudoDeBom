package br.com.ibm.TudoDeBom.controller;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseEntradaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseProductDTO;
import br.com.ibm.TudoDeBom.service.EntradaService;
import br.com.ibm.TudoDeBom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @PostMapping()
    public ResponseEntity<ResponseEntradaDTO> post(@Valid @RequestBody RequestEntradaDTO requestEntradaDTO) {
        ResponseEntradaDTO responseEntradaDTO = entradaService.save(requestEntradaDTO);
        return ResponseEntity.ok(responseEntradaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseEntradaDTO>> get() {
        List<ResponseEntradaDTO> responsesEntradaDTO = entradaService.getAll();
        return ResponseEntity.ok(responsesEntradaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntradaDTO> getProductById(@PathVariable Long id) {
        ResponseEntradaDTO responseEntradaDTO = entradaService.getById(id);
        return ResponseEntity.ok(responseEntradaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseEntradaDTO> put(@Valid @RequestBody RequestEntradaDTO requestEntradaDTO, @PathVariable Long id) {
        ResponseEntradaDTO responseEntradaDTO = entradaService.update(requestEntradaDTO, id);
        return ResponseEntity.ok(responseEntradaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entradaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

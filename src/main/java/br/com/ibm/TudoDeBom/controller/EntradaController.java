package br.com.ibm.TudoDeBom.controller;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseEntradaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseSaidaDTO;
import br.com.ibm.TudoDeBom.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products/{idProduto}/inputs")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @PostMapping()
    public ResponseEntity<ResponseEntradaDTO> post(@Valid @RequestBody RequestEntradaDTO requestEntradaDTO, UriComponentsBuilder uriComponentsBuilder) {
        ResponseEntradaDTO responseEntradaDTO = entradaService.save(requestEntradaDTO);
        URI uri = uriComponentsBuilder.path("/inputs/{idProduto}").buildAndExpand(responseEntradaDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responseEntradaDTO);
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

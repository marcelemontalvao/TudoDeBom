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
@RequestMapping("/products")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @GetMapping("/{idProduct}/inputs")
    public ResponseEntity<ResponseEntradaDTO> getProductById(@PathVariable Long idProduct) {
        ResponseEntradaDTO responseEntradaDTO = entradaService.getById(idProduct);
        return ResponseEntity.ok(responseEntradaDTO);
    }

    @PutMapping("/{idProduct}/inputs")
    public ResponseEntity<Void> put(@Valid @RequestBody RequestEntradaDTO requestEntradaDTO, @PathVariable Long idProduct) {
        entradaService.update(requestEntradaDTO, idProduct);
        return ResponseEntity.noContent().build();
    }

}

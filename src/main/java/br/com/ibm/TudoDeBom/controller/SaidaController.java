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
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class SaidaController {

    @Autowired
    private SaidaService saidaService;

    @Autowired
    private SaidaRepository saidaRepository;

    @GetMapping("/{idProduct}/outputs")
    public ResponseEntity<ResponseSaidaDTO> getSaidaById(@PathVariable Long idProduct) {
        ResponseSaidaDTO responseClienteDTO = saidaService.getById(idProduct);
        return ResponseEntity.ok(responseClienteDTO);
    }

    @PutMapping("/{idProduct}/outputs")
    public ResponseEntity<Void> update(@RequestBody @Valid RequestSaidaDTO request, @PathVariable Long idProduct) {
        saidaService.update(request, idProduct);
        return ResponseEntity.noContent().build();
    }

}

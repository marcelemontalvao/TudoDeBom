package br.com.ibm.TudoDeBom.controller;

import br.com.ibm.TudoDeBom.dto.request.RequestClientDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseClientDTO;
import br.com.ibm.TudoDeBom.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ResponseClientDTO> post(@RequestBody @Valid RequestClientDTO request) {
       ResponseClientDTO responseClientDTO = clientService.save(request);
       return ResponseEntity.ok(responseClientDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponseClientDTO>> get(ResponseClientDTO response) {
        List<ResponseClientDTO> responseClientDTOS = clientService.get();
        return ResponseEntity.ok(responseClientDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseClientDTO> update(@RequestBody @Valid RequestClientDTO request, @PathVariable Long id) {
        clientService.update(request, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

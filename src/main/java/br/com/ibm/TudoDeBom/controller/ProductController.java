package br.com.ibm.TudoDeBom.controller;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestSaidaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseProductDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseSaidaDTO;
import br.com.ibm.TudoDeBom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseProductDTO> postOrder(@RequestBody @Valid RequestProdutoDTO requestProdutoDTO, RequestEntradaDTO requestEntradaDTO, ResponseSaidaDTO responseSaidaDTO, ResponseProductDTO responseProductDTO) {
        productService.save(requestProdutoDTO, requestEntradaDTO,responseSaidaDTO , responseProductDTO);
        return ResponseEntity.ok(responseProductDTO);
    }
    @GetMapping()
    public ResponseEntity<List<ResponseProductDTO>> get(ResponseProductDTO responseClienteDTO) {
        List<ResponseProductDTO> responsesClienteDTO = productService.getAll();
        return ResponseEntity.ok(responsesClienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> getProductById(@PathVariable Long id) {
        ResponseProductDTO responseClienteDTO = productService.getById(id);
        return ResponseEntity.ok(responseClienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> put(@Valid @RequestBody RequestProdutoDTO requestProdutoDTO, @PathVariable Long id) {
        ResponseProductDTO responseClienteDTO = productService.update(requestProdutoDTO, id);
        return ResponseEntity.ok(responseClienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

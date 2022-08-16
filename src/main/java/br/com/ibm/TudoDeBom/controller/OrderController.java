package br.com.ibm.TudoDeBom.controller;

import br.com.ibm.TudoDeBom.dto.request.RequestOrderDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseOrderDTO;
import br.com.ibm.TudoDeBom.repository.OrderRepository;
import br.com.ibm.TudoDeBom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{idProduct}/orders")
    public ResponseEntity<ResponseOrderDTO> getSaidaById(@PathVariable Long idProduct) {
        ResponseOrderDTO responseOrderDTO = orderService.getById(idProduct);
        return ResponseEntity.ok(responseOrderDTO);
    }

    @PutMapping("/{idProduct}/orders")
    public ResponseEntity<Void> update(@RequestBody @Valid RequestOrderDTO request, @PathVariable Long idProduct) {
        orderService.update(request, idProduct);
        return ResponseEntity.noContent().build();
    }

}

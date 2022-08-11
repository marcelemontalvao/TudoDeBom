package br.com.ibm.TudoDeBom.controller;
/*
import br.com.ibm.TudoDeBom.entities.dto.request.RequestOrderDTO;
import br.com.ibm.TudoDeBom.entities.dto.response.ResponseOrderDTO;
import br.com.ibm.TudoDeBom.repository.OrderRepository;
import br.com.ibm.TudoDeBom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


public class OrderController {

    @RestController
@RequestMapping("/pedidos")
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<ResponseOrderDTO> postOrder(@RequestBody @Valid RequestOrderDTO request) {
        ResponseOrderDTO responseOrder = orderService.save(request);
        return ResponseEntity.ok(responseOrder);
    }

    @GetMapping()
    public ResponseEntity<ResponseOrderDTO> getAllOrders(@PathVariable Long id) {
        ResponseOrderDTO responsePedidoDTO = orderService.getAll(id);
        return ResponseEntity.ok(responsePedidoDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid RequestOrderDTO request, @PathVariable Long id) {
        orderService.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
*/
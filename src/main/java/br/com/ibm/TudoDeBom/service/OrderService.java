package br.com.ibm.TudoDeBom.service;

import br.com.ibm.TudoDeBom.dto.request.RequestOrderDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseOrderDTO;
import br.com.ibm.TudoDeBom.entities.OrderEntity;
import br.com.ibm.TudoDeBom.exceptions.OrderNotFoundException;
import br.com.ibm.TudoDeBom.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseOrderDTO getById(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return modelMapper.map(orderEntity, ResponseOrderDTO.class);
    }

    public ResponseOrderDTO update(RequestOrderDTO requestOrderDTO, Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        ResponseOrderDTO map = modelMapper.map(requestOrderDTO, ResponseOrderDTO.class);
        orderRepository.save(orderEntity);
        return map;
    }

}





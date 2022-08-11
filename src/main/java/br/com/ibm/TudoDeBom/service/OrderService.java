package br.com.ibm.TudoDeBom.service;
/*
import br.com.ibm.TudoDeBom.entities.OrderEntity;
import br.com.ibm.TudoDeBom.entities.dto.request.RequestOrderDTO;
import br.com.ibm.TudoDeBom.entities.dto.response.ResponseOrderDTO;
import br.com.ibm.TudoDeBom.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class OrderService {
/*@Service
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseOrderDTO save(RequestOrderDTO request) {
        OrderEntity orderEntity = modelMapper.map(request, OrderEntity.class);
        OrderEntity savedEntity = orderRepository.save(orderEntity);
        return modelMapper.map(savedEntity, ResponseOrderDTO.class);
    }

    public List<ResponseOrderDTO> get(String cpf, String ordenar) {
    }

    public void delete(Long id) {
    }

    public void update(RequestOrderDTO request, Long id) {
    }



    public ResponseOrderDTO getAll(Long id) {
    }

} */




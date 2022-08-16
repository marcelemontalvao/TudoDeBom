package br.com.ibm.TudoDeBom.service;

import br.com.ibm.TudoDeBom.dto.request.RequestInputDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseInputDTO;
import br.com.ibm.TudoDeBom.entities.InputEntity;
import br.com.ibm.TudoDeBom.entities.ProductEntity;
import br.com.ibm.TudoDeBom.exceptions.ProductNotFoundException;
import br.com.ibm.TudoDeBom.repository.InputRepository;
import br.com.ibm.TudoDeBom.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {

    @Autowired
    private InputRepository inputRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseInputDTO getById(Long idProduto){
        ProductEntity product = productRepository.findById(idProduto).orElseThrow(ProductNotFoundException::new);
        InputEntity input = product.getEntrada();
        return modelMapper.map(input, ResponseInputDTO.class);
    }

    public void update(RequestInputDTO requestInputDTO, Long idProduto) {
        ProductEntity product = productRepository.findById(idProduto).orElseThrow(ProductNotFoundException::new);
        InputEntity input = product.getEntrada();
        modelMapper.map(requestInputDTO, input);
        inputRepository.save(input);
    }

}

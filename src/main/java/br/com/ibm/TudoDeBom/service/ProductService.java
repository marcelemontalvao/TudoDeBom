package br.com.ibm.TudoDeBom.service;
import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestSaidaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseProductDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseSaidaDTO;
import br.com.ibm.TudoDeBom.entities.ProdutoEntity;
import br.com.ibm.TudoDeBom.exceptions.ProdutoNotFoundException;
import br.com.ibm.TudoDeBom.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseProductDTO save(RequestProdutoDTO requestProdutoDTO) {
        BigDecimal porcentagem = new BigDecimal("0.8") ;
        BigDecimal quantidade = new BigDecimal(requestProdutoDTO.getEntrada().getQuantidadeEntrada());

        if (requestProdutoDTO.getIsMedicine().equals(true) && requestProdutoDTO.getIsGeneric().equals(true)) {
            ProdutoEntity orderEntity = modelMapper.map(requestProdutoDTO, ProdutoEntity.class);
            ProdutoEntity savedEntity = produtoRepository.save(orderEntity);
            ResponseProductDTO map = modelMapper.map(savedEntity, ResponseProductDTO.class);
            BigDecimal result =  porcentagem.multiply(requestProdutoDTO.getEntrada().getPrecoUnitario()).multiply(quantidade);
            map.getSaida().setValorFinal(result);
            return map;
        }
        ProdutoEntity orderEntity = modelMapper.map(requestProdutoDTO, ProdutoEntity.class);
        ProdutoEntity savedEntity = produtoRepository.save(orderEntity);
        ResponseProductDTO map = modelMapper.map(savedEntity, ResponseProductDTO.class);
        map.getSaida().setValorFinal(requestProdutoDTO.getEntrada().getPrecoUnitario().multiply(quantidade));
        return map;
    }

    public List<ResponseProductDTO> getAll() {
        List<ProdutoEntity> allClients = produtoRepository.findAll();
        List<ResponseProductDTO> dtos = allClients.stream().map(produtoEntity ->
                modelMapper.map(produtoEntity, ResponseProductDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public ResponseProductDTO getById(Long id){
        ProdutoEntity produtoEntity = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
        return modelMapper.map(produtoEntity, ResponseProductDTO.class);
    }

    public ResponseProductDTO update(RequestProdutoDTO requestProdutoDTO, Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
        ResponseProductDTO map = modelMapper.map(requestProdutoDTO, ResponseProductDTO.class);
        produtoRepository.save(produtoEntity);
        return map;
    }

    public void delete(@PathVariable Long id) {
        produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
        produtoRepository.deleteById(id);
    }
}
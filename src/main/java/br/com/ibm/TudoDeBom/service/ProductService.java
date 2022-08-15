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



    public ResponseProductDTO save(@Valid RequestProdutoDTO requestProdutoDTO, RequestEntradaDTO requestEntradaDTOs, ResponseSaidaDTO responseSaidaDTO, ResponseProductDTO responseProductDTO) {
        BigDecimal porcentagem = new BigDecimal("0.8") ;
        BigDecimal quantidade = new BigDecimal(requestEntradaDTOs.getQuantidadeEntrada());

        if (requestProdutoDTO.getIsMedicine().equals(true) && requestProdutoDTO.getIsGeneric().equals(true)) {

            BigDecimal result =  porcentagem.multiply(requestEntradaDTOs.getPrecoUnitario()).multiply(quantidade);
            responseSaidaDTO.setValorFinal(result);

        } else {
            responseSaidaDTO.setValorFinal(requestEntradaDTOs.getPrecoUnitario().multiply(quantidade));
        }

        ProdutoEntity orderEntity = modelMapper.map(responseProductDTO, ProdutoEntity.class);
        ProdutoEntity savedEntity = produtoRepository.save(orderEntity);

        return modelMapper.map(savedEntity, ResponseProductDTO.class);
    }

    public List<ResponseProductDTO> getAll() {
        //usando o método do JpaRepository (findAll()) para obter todos os clientes salvos
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
package br.com.ibm.TudoDeBom.service;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseEntradaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseSaidaDTO;
import br.com.ibm.TudoDeBom.entities.EntradaEntity;
import br.com.ibm.TudoDeBom.entities.ProdutoEntity;
import br.com.ibm.TudoDeBom.exceptions.EntradaNotFoundException;
import br.com.ibm.TudoDeBom.exceptions.ProdutoNotFoundException;
import br.com.ibm.TudoDeBom.repository.EntradaRepository;
import br.com.ibm.TudoDeBom.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntradaDTO getById(Long idProduto){
        ProdutoEntity produto = produtoRepository.findById(idProduto).orElseThrow(ProdutoNotFoundException::new);
        EntradaEntity entrada = produto.getEntrada();
        return modelMapper.map(entrada, ResponseEntradaDTO.class);
    }

    public void update(RequestEntradaDTO requestEntradaDTO, Long idProduto) {
        ProdutoEntity produto = produtoRepository.findById(idProduto).orElseThrow(ProdutoNotFoundException::new);
        EntradaEntity entrada = produto.getEntrada();
        modelMapper.map(requestEntradaDTO, entrada);
        entradaRepository.save(entrada);
    }

}

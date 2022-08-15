package br.com.ibm.TudoDeBom.service;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestSaidaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseSaidaDTO;
import br.com.ibm.TudoDeBom.entities.SaidaEntity;
import br.com.ibm.TudoDeBom.exceptions.SaidaNotFoundException;
import br.com.ibm.TudoDeBom.repository.SaidaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaidaService {

    @Autowired
    private SaidaRepository saidaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseSaidaDTO save(RequestSaidaDTO requestSaidaDTO) {

        SaidaEntity entity = modelMapper.map(requestSaidaDTO, SaidaEntity.class);

        SaidaEntity produtoSaved = saidaRepository.save(entity);

        return modelMapper.map(produtoSaved, ResponseSaidaDTO.class);
    }
    public List<ResponseSaidaDTO> getAll() {
        List<SaidaEntity> allClients = saidaRepository.findAll();

        List<ResponseSaidaDTO> dtos = allClients.stream().map(saidaEntity ->
                modelMapper.map(saidaEntity, ResponseSaidaDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public ResponseSaidaDTO getById(Long id) {
        SaidaEntity saidaEntity = saidaRepository.findById(id).orElseThrow(SaidaNotFoundException::new);
        return modelMapper.map(saidaEntity, ResponseSaidaDTO.class);
    }


    public ResponseSaidaDTO update(RequestSaidaDTO requestSaidaDTO, Long id) {
        SaidaEntity saidaEntity = saidaRepository.findById(id).orElseThrow(SaidaNotFoundException::new);
        ResponseSaidaDTO map = modelMapper.map(requestSaidaDTO, ResponseSaidaDTO.class);
        saidaRepository.save(saidaEntity);
        return map;
    }

    public void delete(@PathVariable Long id) {
        saidaRepository.findById(id).orElseThrow(SaidaNotFoundException::new);
        saidaRepository.deleteById(id);
    }
}





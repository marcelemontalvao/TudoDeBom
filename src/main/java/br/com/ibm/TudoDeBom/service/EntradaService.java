package br.com.ibm.TudoDeBom.service;

import br.com.ibm.TudoDeBom.dto.request.RequestEntradaDTO;
import br.com.ibm.TudoDeBom.dto.request.RequestProdutoDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseEntradaDTO;
import br.com.ibm.TudoDeBom.dto.response.ResponseSaidaDTO;
import br.com.ibm.TudoDeBom.entities.EntradaEntity;
import br.com.ibm.TudoDeBom.exceptions.EntradaNotFoundException;
import br.com.ibm.TudoDeBom.repository.EntradaRepository;
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
    private ModelMapper modelMapper;

    public ResponseEntradaDTO save(RequestEntradaDTO requestEntradaDTO) {
        EntradaEntity entity = modelMapper.map(requestEntradaDTO, EntradaEntity.class);
        EntradaEntity entradaSaved = entradaRepository.save(entity);
        return modelMapper.map(entradaSaved, ResponseEntradaDTO.class);
    }

    public List<ResponseEntradaDTO> getAll() {
        List<EntradaEntity> allClients = entradaRepository.findAll();

        List<ResponseEntradaDTO> dtos = allClients.stream().map(entradaEntity ->
                modelMapper.map(entradaEntity, ResponseEntradaDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public ResponseEntradaDTO getById(Long id){
        EntradaEntity entradaEntity = entradaRepository.findById(id).orElseThrow(EntradaNotFoundException::new);
        return modelMapper.map(entradaEntity, ResponseEntradaDTO.class);
    }


    public ResponseEntradaDTO update(@Valid RequestEntradaDTO requestEntradaDTO, Long id) {
        EntradaEntity entradaEntity = entradaRepository.findById(id).orElseThrow(EntradaNotFoundException::new);
        ResponseEntradaDTO map = modelMapper.map(requestEntradaDTO, ResponseEntradaDTO.class);
        entradaRepository.save(entradaEntity);
        return map;
    }

    public void delete(@PathVariable Long id) {
        entradaRepository.findById(id).orElseThrow(EntradaNotFoundException::new);
        entradaRepository.deleteById(id);
    }
}

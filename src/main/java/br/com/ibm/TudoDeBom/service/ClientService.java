package br.com.ibm.TudoDeBom.service;

import br.com.ibm.TudoDeBom.entities.ClientEntity;
import br.com.ibm.TudoDeBom.entities.dto.request.RequestClientDTO;
import br.com.ibm.TudoDeBom.entities.dto.response.ResponseClientDTO;
import br.com.ibm.TudoDeBom.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseClientDTO save(RequestClientDTO requestClientDTO) {
        ClientEntity entity = modelMapper.map(requestClientDTO, ClientEntity.class);
        ClientEntity saved = clientRepository.save(entity);
        return modelMapper.map(saved, ResponseClientDTO.class);
    }

    public List<ResponseClientDTO> get() {
        List<ClientEntity> allClients = clientRepository.findAll();
        List<ResponseClientDTO> dtos = allClients.stream().map(clientEntity ->
                modelMapper.map(clientEntity, ResponseClientDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public void delete(Long id) {
        clientRepository.findById(id);
        clientRepository.deleteById(id);
    }

    public void update(RequestClientDTO request, Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        modelMapper.map(request, clientEntity);
        clientRepository.save(clientEntity);
    }
}

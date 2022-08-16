package br.com.ibm.TudoDeBom.service;

import br.com.ibm.TudoDeBom.AplicationConfigTest;
import br.com.ibm.TudoDeBom.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
/*/
@DisplayName("ClientServiceTest")
public class ClientService extends AplicationConfigTest {

    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private ClientService clientService;

    @Test
    @DisplayName("deve remover um cliente")
    public void deveRemoverCliente() {
        Long clientId = "id-mock";
        Optional<ClientA> client = Optional.of(cadastrarCliente());
        Mockito.when(clientRepository.findById(ArgumentMatchers.eq(clientId))).thenReturn(client);
        clientService.delete(clientId);

    }

   private ClientA cadastrarCliente() {
    ClientA client = Mockito.mock(ClientA.class);
    return client;
   }
}
*/
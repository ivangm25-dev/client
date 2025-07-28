package com.example.wimg.service;

import com.example.wimg.config.BuilderConfiguration;
import com.example.wimg.entity.dto.MessageDTO;
import com.example.wimg.entity.dto.ResponseClientDTO;
import com.example.wimg.entity.enums.CustomerType;
import com.example.wimg.entity.repository.ClientEntity;
import com.example.wimg.exception.GenericException;
import com.example.wimg.mock.ClientBuilderMock;
import com.example.wimg.repository.ClientRepository;
import com.example.wimg.utils.BuilderUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(classes = {BuilderConfiguration.class})
public class ClientServiceImplTest {

    @Autowired
    private BuilderUtil<ClientEntity> clientEntityBuilder;
    @Autowired
    private BuilderUtil<ResponseClientDTO> responseClientDTOBuilder;
    @Mock
    private BuilderUtil<ClientEntity> mockClientEntityBuilder;
    @Mock
    private BuilderUtil<ResponseClientDTO> mockResponseClientDTOBuilder;
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientService clientService = new ClientServiceImpl();

    @Test
    public void createNewClientRegularTest(){
        ClientEntity clientEntity = 
                clientEntityBuilder.objectBuilder(ClientBuilderMock.createNewClient(CustomerType.REGULAR));
        clientEntity.setDiscount(false);
        ResponseClientDTO responseClientDTO =
                responseClientDTOBuilder.objectBuilder(clientEntity);
        Mockito.when(mockClientEntityBuilder.objectBuilder(Mockito.any()))
                .thenReturn(clientEntity);
        Mockito.when(mockResponseClientDTOBuilder.objectBuilder(Mockito.any()))
                .thenReturn(responseClientDTO);
        ResponseClientDTO response = clientService.createClient(ClientBuilderMock.createNewClient(CustomerType.REGULAR));
        Assertions.assertEquals(response.customerType(), responseClientDTO.customerType());
        Assertions.assertEquals(response.discount(), false);
    }

    @Test
    public void createNewClientVipTest(){
        ClientEntity clientEntity =
                clientEntityBuilder.objectBuilder(ClientBuilderMock.createNewClient(CustomerType.VIP));
        clientEntity.setDiscount(true);
        ResponseClientDTO responseClientDTO =
                responseClientDTOBuilder.objectBuilder(clientEntity);
        Mockito.when(mockClientEntityBuilder.objectBuilder(Mockito.any()))
                .thenReturn(clientEntity);
        Mockito.when(mockResponseClientDTOBuilder.objectBuilder(Mockito.any()))
                .thenReturn(responseClientDTO);
        ResponseClientDTO response = clientService.createClient(ClientBuilderMock.createNewClient(CustomerType.VIP));
        Assertions.assertEquals(response.customerType(), responseClientDTO.customerType());
        Assertions.assertEquals(response.discount(), true);
    }

    @Test
    public void createNewClientRegularReturnErrorTest(){
        ClientEntity clientEntity =
                clientEntityBuilder.objectBuilder(ClientBuilderMock.createNewClient(CustomerType.REGULAR));
        clientEntity.setDiscount(false);
        Assertions.assertThrows(GenericException.class,
                () -> clientService.createClient(
                        ClientBuilderMock.createNewClient(CustomerType.REGULAR)));
    }

    @Test
    public void getAllClientsTest(){
        ClientEntity clientEntity = clientEntityBuilder.objectBuilder(
                ClientBuilderMock.createNewClient(CustomerType.REGULAR));

        List<ClientEntity> listClient= new ArrayList<>();
        listClient.add(clientEntity);

        List<ResponseClientDTO> responseListClientDTO =
                responseClientDTOBuilder.objectListBuilder(listClient);

        Mockito.when(mockResponseClientDTOBuilder.objectListBuilder(Mockito.any()))
                .thenReturn(responseListClientDTO);

        Mockito.when(clientRepository.getAllClients()).thenReturn(listClient);

        List<ResponseClientDTO> response = clientService.getAllClients();
        Assertions.assertEquals(response.size(), 1);
        Assertions.assertEquals(response.get(0).customerType(), CustomerType.REGULAR);
    }

    @Test
    public void updateClientTest(){
        ClientEntity clientEntity = clientEntityBuilder.objectBuilder(
                ClientBuilderMock.createNewClient(CustomerType.VIP));
        clientEntity.setDiscount(true);

        ResponseClientDTO responseClientDTO =
                responseClientDTOBuilder.objectBuilder(clientEntity);

        Mockito.when(mockResponseClientDTOBuilder.objectBuilder(Mockito.any()))
                .thenReturn(responseClientDTO);

        Mockito.when(clientRepository.updateClient(Mockito.any())).thenReturn(true);

        ResponseClientDTO response = clientService.updateClient(ClientBuilderMock.createNewClient(CustomerType.VIP));
        Assertions.assertEquals(response.id(), "1");
        Assertions.assertEquals(response.customerType(), CustomerType.VIP);
    }

    @Test
    public void deleteClientTest(){
        String clientId = "1";
        MessageDTO messageDTO = new MessageDTO("Delete client with id :"+ clientId);
        MessageDTO response = clientService.deleteClient(clientId);
        Assertions.assertEquals(response.message(), messageDTO.message());
    }
}

package com.example.wimg.service;

import com.example.wimg.entity.dto.MessageDTO;
import com.example.wimg.entity.dto.RequestClientDTO;
import com.example.wimg.entity.dto.ResponseClientDTO;
import com.example.wimg.entity.repository.ClientEntity;
import com.example.wimg.exception.GenericException;
import com.example.wimg.repository.ClientRepository;
import com.example.wimg.utils.BuilderUtil;
import com.example.wimg.utils.CustomerTypeUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BuilderUtil<ClientEntity> clientEntityBuilder;
    @Autowired
    private BuilderUtil<ResponseClientDTO> responseClientBuilder;

    @Override
    public ResponseClientDTO createClient(RequestClientDTO requestClient) {
        try {
            ClientEntity clientEntity =
                    clientEntityBuilder.objectBuilder(requestClient);
            clientEntity.setDiscount(
                    CustomerTypeUtil.hasDiscount(requestClient.customerType()));
            clientRepository.createClient(clientEntity);
            return responseClientBuilder.objectBuilder(requestClient);
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }
    }

    @Override
    public List<ResponseClientDTO> getAllClients() {
        List<ClientEntity> clients= clientRepository.getAllClients();
        return responseClientBuilder.objectListBuilder(clients);
    }

    @Override
    public ResponseClientDTO updateClient(RequestClientDTO requestClient) {
        ClientEntity clientEntity =
                clientEntityBuilder.objectBuilder(requestClient);
        clientRepository.updateClient(clientEntity);
        return responseClientBuilder.objectBuilder(clientEntity);
    }

    @Override
    public MessageDTO deleteClient(String clientId) {
        clientRepository.deleteClient(clientId);
        return new MessageDTO("Delete client with id :"+ clientId);
    }
}

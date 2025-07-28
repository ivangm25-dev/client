package com.example.wimg.repository;

import com.example.wimg.exception.GenericException;
import com.example.wimg.entity.repository.ClientEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientRepositoryImpl implements ClientRepository {

    public static final List<ClientEntity> clients = new ArrayList<>();

    @Override
    public void createClient(ClientEntity client) {
        if (findClient(client.getId()))
            throw new GenericException("Error: Duplicate ID");
        clients.add(client);
    }

    @Override
    public ClientEntity getClient(ClientEntity client) {
        return clients.stream().filter(aux -> aux.getId()
                .equals(client.getId())).findAny().orElseThrow();
    }

    @Override
    public ClientEntity getClient(String clientId) {
        if (!findClient(clientId))
            throw new GenericException("Error: Client Not Found.");
        return clients.get(getIndex(clientId));
    }

    @Override
    public List<ClientEntity> getAllClients() {
        return clients;
    }

    @Override
    public boolean updateClient(ClientEntity client) {
        if(!findClient(client.getId()))
            throw new GenericException("Error: Client does not exist.");
        clients.set(getIndex(client.getId()), client);
        return true;
    }

    @Override
    public void deleteClient(String clientId) {
        if (!findClient(clientId))
            throw new GenericException("Error: Client does not exist.");
        clients.remove(getIndex(clientId));
    }

    private boolean findClient(String id){
        return clients.stream()
                .anyMatch(aux -> aux.getId().equals(id));
    }

    private int getIndex(String clientId){
        return clients.stream()
                .map(ClientEntity::getId)
                .toList()
                .indexOf(clientId);
    }
}

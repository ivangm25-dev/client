package com.example.wimg.repository;

import com.example.wimg.entity.repository.ClientEntity;
import java.util.List;

public interface ClientRepository {

    /**
     * Create new client.
     * @param
     */
    void createClient(ClientEntity client);

    /**
     * Get Client.
     * @param client
     * @return Client.
     */
    ClientEntity getClient(ClientEntity client);

    /**
     * Get Client.
     * @param clientId
     * @return Client.
     */
    ClientEntity getClient(String clientId);

    /**
     * Get all clients.
     * @return List<Client>.
     */
    List<ClientEntity> getAllClients();

    /**
     * Update client by id.
     * @param client
     * @return True or False.
     */
    boolean updateClient(ClientEntity client);

    /**
     * Delete client by id.
     * @param
     */
    void deleteClient(String clientId);

}

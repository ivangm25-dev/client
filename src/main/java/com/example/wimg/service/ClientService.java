package com.example.wimg.service;

import com.example.wimg.entity.dto.MessageDTO;
import com.example.wimg.entity.dto.RequestClientDTO;
import com.example.wimg.entity.dto.ResponseClientDTO;
import java.util.List;

public interface ClientService {

    /**
     * Create new client.
     * @param requestClient
     * @return ResponseClientDTO.
     */
    ResponseClientDTO createClient(RequestClientDTO requestClient);

    /**
     * Get all clients.
     * @return List<ResponseClientDTO>.
     */
    List<ResponseClientDTO> getAllClients();

    /**
     * Update Client.
     * @param requestClient
     * @return ResponseClientDTO.
     */
    ResponseClientDTO updateClient(RequestClientDTO requestClient);

    /**
     * Delete client by id.
     * @param clientId
     * @return MessageDTO.
     */
    MessageDTO deleteClient(String clientId);

}

package com.example.wimg.controller;

import static com.example.wimg.utils.Constants.PARAM_CLIENT_ID;
import static com.example.wimg.utils.Constants.PATH_CLIENT_CONTROLLER;

import com.example.wimg.entity.dto.RequestClientDTO;
import com.example.wimg.service.ClientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PATH_CLIENT_CONTROLLER)
public class ClientController {

    private static final Logger logger =
            LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @PostMapping()
    public ResponseEntity<?> createClient(@Valid @RequestBody RequestClientDTO requestClient){
        logger.info("Create new client. id: %s, name : %s, customerType: %s."
                .formatted(requestClient.id(), requestClient.name(), requestClient.customerType()));
        return new ResponseEntity<>(
                clientService.createClient(requestClient), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getClients(){
        logger.info("Get all clients.");
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateClient(@Valid @RequestBody RequestClientDTO requestClient){
        logger.info("Update client. id: %s.".formatted(requestClient.id()));
        return new ResponseEntity<>(clientService.updateClient(requestClient), HttpStatus.OK);
    }

    @DeleteMapping(PARAM_CLIENT_ID)
    public ResponseEntity<?> deleteClient(@PathVariable String clientId){
        logger.info("Delete client. id: %s.".formatted(clientId));
        return ResponseEntity.ok().body(clientService.deleteClient(clientId));
    }

}

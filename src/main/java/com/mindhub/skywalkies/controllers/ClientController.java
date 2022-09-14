package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.ClientDTO;
import com.mindhub.skywalkies.repositories.ClientRespository;
import com.mindhub.skywalkies.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientRespository clientRespository;
    @Autowired
    private ClientService clientService;

    @RequestMapping("/users")
    public List<ClientDTO> getUsers(){
        return clientService.getAllClients().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

}

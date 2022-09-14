package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.ClientDTO;
import com.mindhub.skywalkies.repositories.AvatarRepository;
import com.mindhub.skywalkies.services.AvatarService;
import com.mindhub.skywalkies.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class AvatarController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/avatars")
    public List<ClientDTO> getClients(){
        return clientService.getAllClients().stream().map(account -> new ClientDTO(account)).collect(toList());
    }

    @GetMapping("/avatars/{id}")
    public ClientDTO getAccount(@PathVariable long id){

        return new ClientDTO(clientService.getClientById(id));
    }
}

package com.mindhub.skywalkies.Service.implementations;

import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplements implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientCurrent(Authentication authentication) {
        return clientRepository.findByEmail(authentication.getName());
    }
}

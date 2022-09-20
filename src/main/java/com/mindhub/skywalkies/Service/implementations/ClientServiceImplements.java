package com.mindhub.skywalkies.Service.implementations;

import com.mindhub.skywalkies.Service.ClientService;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Client_order;
import com.mindhub.skywalkies.repositories.ClientRepository;
import com.mindhub.skywalkies.repositories.Client_OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplements implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    Client_OrderRepository client_orderRepository;

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



}

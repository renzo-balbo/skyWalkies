package com.mindhub.skywalkies.Service;

import com.mindhub.skywalkies.models.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(long id);

    Client findClientByEmail(String email);

    void saveClient(Client client);
}

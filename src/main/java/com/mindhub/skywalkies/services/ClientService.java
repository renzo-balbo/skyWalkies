package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Client;

import java.util.List;

public interface ClientService {


    List<Client> getAllUsers();

    Client getUserById(long id);

    Client findUserByemail(String email);
}

package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Client;

import java.util.List;

public interface ClientServices {
    List<Client> getAllUsers();

    Client getUserById(long id);

    Client findUserByemail(String email);
}

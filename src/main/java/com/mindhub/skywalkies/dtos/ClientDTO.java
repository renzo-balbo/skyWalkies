package com.mindhub.skywalkies.dtos;


import com.mindhub.skywalkies.models.Client;

public class ClientDTO {
    private long id;
    private String firstName,lastName,email,password;
    private boolean verificated;
    public ClientDTO() {
    }

    public ClientDTO (Client client) {
       this.id = client.getId();
       this.firstName = client.getFirstName();
       this.lastName = client.getLastName();
       this.email = client.getEmail();
       this.password = client.getPassword();
       this.verificated = client.isVerificated();
    }


}

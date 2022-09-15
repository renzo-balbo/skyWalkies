package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Avatar;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Shoe;

import java.util.Set;

public class ClientDTO {
    private long id;

    private String  firstName, lastName, email, password;

    private Set<Shoe> shoes;
    private boolean verificated;
    private Avatar avatar;

    public ClientDTO() {
    }


    public ClientDTO(Client client){
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.verificated = client.isVerificated();
        this.shoes = client.getShoes();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public boolean isVerificated() {
        return verificated;
    }

    public Set<Shoe> getShoes() {
        return shoes;
    }

}

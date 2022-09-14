package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Client;

public class ClientDTO {
    private long id;

    private String  firstName, lastName, email, password;


    private boolean verificated;

    public ClientDTO() {
    }


    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.verificated = client.isVerificated();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerificated() {
        return verificated;
    }

    public void setVerificated(boolean verificated) {
        this.verificated = verificated;
    }
}

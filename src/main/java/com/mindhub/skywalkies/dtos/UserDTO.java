package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.User;

public class UserDTO {
    private long id;

    private String  firstName, lastName, email, password;


    private boolean verificated;

    public UserDTO() {
    }


    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.verificated = user.isVerificated();
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

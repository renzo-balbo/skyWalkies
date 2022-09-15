package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<ClientCart> clientCarts = new HashSet<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Shoe> shoes = new HashSet<>();

    private String  firstName, lastName, email, password;
    private boolean isVerificated;


    public Client() {
    }

    public Client(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isVerificated = true;
    }
    public Client(String firstName, String lastName, String email, String password, Set<Shoe> shoes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isVerificated = true;
        this.shoes = shoes;
    }

    public long getId() {
        return id;
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
        return isVerificated;
    }

    public void setVerificated(boolean verificated) {
        isVerificated = verificated;
    }

    public Set<ClientCart> getClientCarts() {
        return clientCarts;
    }

    public void setClientCarts(Set<ClientCart> clientCarts) {
        this.clientCarts = clientCarts;
    }

    public Set<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(Set<Shoe> shoes) {
        this.shoes = shoes;
    }
    public void addShoe (Shoe shoe){
        shoe.setClient(this);
        shoes.add(shoe);
    }
}
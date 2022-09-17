package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "billId", fetch = FetchType.EAGER)
    private Set<Client_order> client_orders = new HashSet<>();

     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "client_id")
     private Client client;

    private LocalDateTime date;
    private boolean payed;
    private double subTotal;

    public Bill() {
    }

    public Bill(LocalDateTime date, boolean payed, double subTotal) {
        this.date = date;
        this.payed = payed;
        this.subTotal = subTotal;
    }
    public Bill(LocalDateTime date, boolean payed, double subTotal, Client client) {
        this.date = date;
        this.payed = payed;
        this.subTotal = subTotal;
    }


    public long getId() {
        return id;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double totalAmount) {
        this.subTotal = totalAmount;
    }

    public Set<Client_order> getClient_orders() {
        return client_orders;
    }

    public void setClient_orders(Set<Client_order> client_orders) {
        this.client_orders = client_orders;
    }

    public void addClient_order(Client_order client_order){
        client_order.setBillId(this);
        client_orders.add(client_order);
    }

}

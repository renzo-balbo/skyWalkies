package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "client_id")
     private Client client;

    private long order_id;

    private LocalDateTime date;
    private boolean payed;
    private double totalAmount;

    public Bill() {
    }

    public Bill(LocalDateTime date, boolean payed, double totalAmount) {
        this.date = date;
        this.payed = payed;
        this.totalAmount = totalAmount;
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

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


}

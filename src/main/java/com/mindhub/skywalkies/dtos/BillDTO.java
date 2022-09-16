package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Client_order;
import com.mindhub.skywalkies.models.Ordered_product;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class BillDTO {
    private long id;


    private LocalDateTime date;
    private Boolean payed;
    private Double totalAmount;

    private Set<Client_order> client_orders;


    public BillDTO() {
    }

    public BillDTO(Bill bill) {
        this.id = bill.getId();
        this.date = bill.getDate();
        this.payed = bill.isPayed();
        this.totalAmount = bill.getTotalAmount();
        this.client_orders = bill.getClient_orders().stream().map(client_order -> new Client_order()).collect(Collectors.toSet());

    }


    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Boolean getPayed() {
        return payed;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Set<Client_order> getClient_orders() {
        return client_orders;
    }
}

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
    private boolean payed;
    private double subTotal;

    private Set<Client_orderDTO> client_orders;


    public BillDTO() {
    }

    public BillDTO(Bill bill) {
        this.id = bill.getId();
        this.date = bill.getDate();
        this.payed = bill.isPayed();
        this.subTotal = bill.getSubTotal();
        this.client_orders = bill.getClient_orders().stream().map(client_order -> new Client_orderDTO(client_order)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isPayed() {
        return payed;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public Set<Client_orderDTO> getClient_orders() {
        return client_orders;
    }
}

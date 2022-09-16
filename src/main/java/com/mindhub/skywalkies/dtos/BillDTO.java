package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Client_order;
import com.mindhub.skywalkies.models.Ordered_product;

import java.time.LocalDateTime;

public class BillDTO {
    private long id;
    private long client_id;

    private long client_order;

    private LocalDateTime date;
    private Boolean payed;
    private Double totalAmount;




    public BillDTO() {
    }

    public BillDTO(Bill bill) {
        this.id = bill.getId();
        this.date = bill.getDate();
        this.payed = bill.isPayed();
        this.totalAmount = bill.getTotalAmount();
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

    public long getClient_id() {
        return client_id;
    }

    public long getClient_order() {
        return client_order;
    }
}

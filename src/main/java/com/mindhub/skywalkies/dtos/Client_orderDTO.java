package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Client_order;

import java.util.Set;

public class Client_orderDTO {

    private long id;
    private long billId;



    public Client_orderDTO(Client_order client_order) {
        this.id = client_order.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }
}

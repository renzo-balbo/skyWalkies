package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Client_order;
import com.mindhub.skywalkies.models.Ordered_product;

import java.util.Set;
import java.util.stream.Collectors;

public class Client_orderDTO {

    private long id;
    private long billId;

    private Set<Ordered_productDTO> ordered_productDTOS;


    public Client_orderDTO(Client_order client_order) {
        this.id = client_order.getId();
        this.ordered_productDTOS = client_order.getOrdered_products().stream().map(ordered_product -> new Ordered_productDTO()).collect(Collectors.toSet());
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

    public void setOrdered_productDTOS(Set<Ordered_productDTO> ordered_productDTOS) {
        this.ordered_productDTOS = ordered_productDTOS;
    }


}

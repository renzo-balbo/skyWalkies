package com.mindhub.skywalkies.dtos;

import java.time.LocalDateTime;

public class BillDTO {
    private LocalDateTime date;
    private Boolean payed;
    private Double totalAmount;


    public BillDTO() {
    }

    public BillDTO(LocalDateTime date, Boolean payed, Double totalAmount) {
        this.date = date;
        this.payed = payed;
        this.totalAmount = totalAmount;
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
}

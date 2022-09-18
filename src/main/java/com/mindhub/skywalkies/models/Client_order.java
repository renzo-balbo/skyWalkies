package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client_order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id")
    private Bill billId;

    //@OneToMany(mappedBy = "client_order",fetch = FetchType.EAGER)
    // private Set<Ordered_product> ordered_products = new HashSet<>();

    public Client_order() {
    }

    public Client_order(Ordered_product ordered_product, Bill Bill) {
        this.id = id;
        this.billId = billId;
    }

    public long getId() {
        return id;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }


    public void add(Client_order client_order) {
    }
}
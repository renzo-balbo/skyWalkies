package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client_order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private long ordered_product_id;

    public Client_order() {
    }

    public Client_order(Ordered_product ordered_product) {
        this.id = id;
        this.ordered_product_id = ordered_product.getProduct_id();
    }
    public long getId() {
        return id;
    }
    public long getOrdered_product_id() {
        return ordered_product_id;
    }
}

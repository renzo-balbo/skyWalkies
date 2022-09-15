package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordered_product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private long product_id;
    private int quantity;

    public Ordered_product() {
    }

    public Ordered_product(long product_id, int quantity, Product product) {
        this.id = id;
        this.product_id = product.getId();
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }


    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

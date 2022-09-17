package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Product;

import java.util.HashSet;
import java.util.Set;

public class ordered_productDTO {
    private long id, product_id;
    private int quantity;

    private Set<Product> products;
    public ordered_productDTO() {
    }

    public ordered_productDTO(long id, long product_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;

    }

    public long getId() {
        return id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Set<Product> getProducts() {
        return products;
    }
}

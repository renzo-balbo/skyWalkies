package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Ordered_product;
import com.mindhub.skywalkies.models.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class Ordered_productDTO {
    private long  client_order_id;
    private int quantity;

    private Set<Product> products;

    public Ordered_productDTO() {
    }

    public Ordered_productDTO(Ordered_product ordered_product) {
        this.client_order_id = ordered_product.getClient_order().getId();
        this.quantity = ordered_product.getQuantity();
        this.products = (Set<Product>) ordered_product.getProduct();
    }

    public long getClient_order_id() {
        return client_order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Set<Product> getProducts() {
        return products;
    }
}

package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Ordered_product;

import java.util.Set;
import java.util.stream.Collectors;

public class Ordered_productDTO {
    private long id, product_id;
    private int quantity;

    private Set<ProductDTO> products;

    private Set<Ordered_productDTO> ordered_productDTOs;
    public Ordered_productDTO() {
    }

    public Ordered_productDTO(Ordered_product ordered_product) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.products = getProducts().stream().map(product -> new ProductDTO(product)).collect(Collectors.toSet());
        this.ordered_productDTOs = ordered_product.getProducts().stream().map(order -> new Ordered_productDTO(ordered_product)).collect(Collectors.toSet());

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

    public Set<ProductDTO> getProducts() {
        return products;
    }
}

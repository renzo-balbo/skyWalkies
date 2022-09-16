package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Product;

public class ProductDTO {

    private String name, color, type;

    private Boolean active;

    private int size;

    private int stock;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.active = product.getActive();
        this.size = product.getSize();
        this.color = product.getColor();
        this.stock = product.getStock();
        this.type = product.getType();
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public Boolean getActive() {
        return active;
    }

    public int getSize() {
        return size;
    }

    public int getStock() {
        return stock;
    }
}

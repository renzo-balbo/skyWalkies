package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Product;

import java.util.List;

public class ProductDTO {
    private long id;

    private String name, color, type;

    private Boolean active;

    private List<Integer> sizes;

    private int stock;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.active = product.getActive();
        this.sizes = product.getSize();
        this.color = product.getColor();
        this.stock = product.getStock();
        this.type = product.getType();
        this.price = product.getPrice();
    }

    public long getId() {
        return id;
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

    public List<Integer> getSizes() {
        return sizes;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }
}

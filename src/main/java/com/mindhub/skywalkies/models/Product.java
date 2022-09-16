package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordered_product_id")
    private Ordered_product products;

    private String name, color, type;

    private boolean active;
    @ElementCollection
    @Column(name = "sizes")
    private List<Integer> size;

    private int stock;
    private double price;

    public Product() {
    }

    public Product(String name, String color, String type, Boolean active, List<Integer> size, int stock, double price) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.active = active;
        this.size = size;
        this.stock = stock;
        this.price = price;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Integer> getSize() {
        return size;
    }

    public void setSize(List<Integer> size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Ordered_product getProducts() {
        return products;
    }

    public void setProducts(Ordered_product products) {
        this.products = products;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

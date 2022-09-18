package com.mindhub.skywalkies.models;

import com.mindhub.skywalkies.dtos.ProductDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Ordered_product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productt_id")
    private Product products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_order_id")
    private Client_order client_order;

    private long clientt_order;
    private long product_id;
    private int quantity;

    public Ordered_product() {
    }

    public Ordered_product(long client_order, long product_id, int quantity, Product productt) {
        this.clientt_order = client_order;
        this.product_id = product_id;
        this.quantity = quantity;

    }


    public long getId() {
        return id;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Client_order getClient_order() {
        return client_order;
    }

    public void setClient_order(Client_order client_order) {
        this.client_order = client_order;
    }

    public long getClientt_order() {
        return clientt_order;
    }

    public void setClientt_order(long clientt_order) {
        this.clientt_order = clientt_order;
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


    public Product getProducts() {
        return products;
    }



}

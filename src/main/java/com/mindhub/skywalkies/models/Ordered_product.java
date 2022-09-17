package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Ordered_product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    // @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
    //private Set<Product> products = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_order_id")
    private Client_order client_orders;
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


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Client_order getClient_order() {
        return client_orders;
    }

    public void setClient_order(Client_order client_order) {
        this.client_orders = client_order;
    }

    public long getProduct_id() {
        return product_id;
    }

}

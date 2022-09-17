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
   // private Set<Product> product = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_order_id")
    private Client_order client_order;

    private long product_id;
    private int quantity;

    public Ordered_product() {
    }

    public Ordered_product(long product_id, int quantity, Product product) {
        this.id = id;
        this.product_id = product.getId();
        this.quantity = quantity;
        //this.product = getProduct().stream().map(product1 -> new Product()).collect(Collectors.toSet());

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

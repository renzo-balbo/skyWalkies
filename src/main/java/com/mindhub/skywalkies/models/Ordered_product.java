package com.mindhub.skywalkies.models;

import com.mindhub.skywalkies.dtos.ProductDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Ordered_product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_order_id")
    private Client_order client_order;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private  Product product;



    private int quantity;

    public Ordered_product() {
    }

    public Ordered_product(Product product, Client_order client_order) {
        this.client_order = client_order;
        this.product = product;
        this.quantity = quantity;
        this.addProductos(product);

    }
    public Ordered_product(Product product) {
        this.client_order = client_order;
        this.product = product;
        this.quantity = quantity;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public Client_order getClient_order() {
        return client_order;
    }

    public void setClient_order(Client_order client_order) {
        this.client_order = client_order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> addProductos(Product product){
        product.setOrdered_products(this);
        return addProductos(product);
    }


}

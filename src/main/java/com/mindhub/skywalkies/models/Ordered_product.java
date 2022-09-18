package com.mindhub.skywalkies.models;

import com.mindhub.skywalkies.dtos.ProductDTO;
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


    @OneToMany(mappedBy = "ordered_product", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

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
        this.products = getProducts();

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
        return client_order;
    }

    public void setClient_order(Client_order client_order) {
        this.client_order = client_order;
    }

    public long getProduct_id() {
        return product_id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Client_order getClient_orders() {
        return client_order;
    }

    public void setClient_orders(Client_order client_orders) {
        this.client_order = client_orders;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public void addProducts(Product product){
        product.setOrdered_product(this);
        products.add(product);
    }


}

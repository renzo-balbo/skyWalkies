package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client_order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id")
    private Bill billId;

   // @OneToMany(mappedBy = "client_order",fetch = FetchType.EAGER)
   // private Set<Ordered_product> ordered_products = new HashSet<>();

    @OneToMany(mappedBy = "client_order", fetch = FetchType.EAGER)
    private Set<Client_order> client_order = new HashSet<>();

    private long ordered_product_id;

    public Client_order() {
    }

    public Client_order(Ordered_product ordered_product) {
        this.id = id;
        this.ordered_product_id = ordered_product.getProduct_id();


    }

    public long getId() {
        return id;
    }
    public long getOrdered_product_id() {
        return ordered_product_id;
    }



    public void setOrdered_product_id(long ordered_product_id) {
        this.ordered_product_id = ordered_product_id;
    }






    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }




}

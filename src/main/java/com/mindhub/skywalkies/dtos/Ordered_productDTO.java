package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Ordered_product;

import java.util.Set;
import java.util.stream.Collectors;

public class Ordered_productDTO {
    private long product_id, client_order_id;
    private int quantity;

    private Set<ProductDTO> products;

    public Ordered_productDTO() {
    }

    public Ordered_productDTO(Ordered_product ordered_product) {
        this.product_id = getProduct_id();
        this.client_order_id = ordered_product.getClientt_order();
        this.quantity = ordered_product.getQuantity();

    }


    public long getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Set<ProductDTO> getProductS() {
        return products;
    }

}

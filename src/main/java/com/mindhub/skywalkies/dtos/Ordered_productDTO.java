package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Ordered_product;
import com.mindhub.skywalkies.models.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class Ordered_productDTO {
//    private long product_id, client_order_id;
//    private int quantity;
//
//    private Product products;
//
//    public Ordered_productDTO() {
//    }
//
//    public Ordered_productDTO(Ordered_product ordered_product) {
////        this.product_id = ordered_product.getProduct_id();
//        this.client_order_id = ordered_product.getClient_order().getId();
//        this.quantity = ordered_product.getQuantity();
//        this.products = ordered_product.getProduct();
//    }
//
//
//    public long getProduct_id() {
//        return product_id;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public Product getProduct() {
//        return products;
//    }

    private long product_id, client_order_id;

    private int quantity;

    private ProductDTO productDTO;

    public Ordered_productDTO() {
    }

    public Ordered_productDTO(Ordered_product ordered_product) {
        this.product_id = ordered_product.getProduct().getId();
        this.client_order_id = ordered_product.getClient_order().getId();
        this.quantity = ordered_product.getQuantity();
        this.productDTO = new ProductDTO(ordered_product.getProduct());
    }

    public long getProduct_id() {
        return product_id;
    }

    public long getClient_order_id() {
        return client_order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }
}

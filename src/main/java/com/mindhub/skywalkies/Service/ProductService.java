package com.mindhub.skywalkies.Service;

import com.mindhub.skywalkies.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(long id);

    void saveProduct(Product product);
}

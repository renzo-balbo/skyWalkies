package com.mindhub.skywalkies.Service;

import com.mindhub.skywalkies.models.Ordered_product;

import java.util.List;

public interface Ordered_productService {
    List<Ordered_product> getAllOrderProducts();

    Ordered_product getProdutById(long id);

    void saveOrderProduct(Ordered_product ordered_product);
}

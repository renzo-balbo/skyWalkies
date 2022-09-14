package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Cart;

import java.util.Arrays;
import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();

    Cart getCartById(long id);

    void saveCart(Cart cart);


}

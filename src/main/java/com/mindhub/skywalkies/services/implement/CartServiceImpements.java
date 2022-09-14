package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Cart;
import com.mindhub.skywalkies.repositories.CartRepository;
import com.mindhub.skywalkies.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpements implements CartService {
    @Autowired
    public CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts(){return cartRepository.findAll();}

    @Override
    public Cart getCartById(long id){return cartRepository.findById(id).get();}

    @Override
    public void saveCart(Cart cart){cartRepository.save(cart);}
}

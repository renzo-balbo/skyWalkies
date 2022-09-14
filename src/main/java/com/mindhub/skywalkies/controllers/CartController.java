package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.CartDTO;
import com.mindhub.skywalkies.repositories.CartRepository;
import com.mindhub.skywalkies.repositories.ClientRespository;
import com.mindhub.skywalkies.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ClientRespository clientRespository;
    @Autowired
    private CartService cartService;

    @RequestMapping ("/carts")
    public List<CartDTO> getAccounts(){
        return cartService.getAllCarts().stream().map(CartDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/cart/{id}")
    public CartDTO getCart(@PathVariable long id){return  new CartDTO(cartService.getCartById(id));}

}

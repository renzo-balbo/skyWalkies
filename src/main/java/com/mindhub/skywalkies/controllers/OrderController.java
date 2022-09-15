package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.OrderDTO;
import com.mindhub.skywalkies.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public List<OrderDTO> getOrders(){
        return orderService.allOrder().stream().map(OrderDTO::new).collect(Collectors.toList());
    }


}

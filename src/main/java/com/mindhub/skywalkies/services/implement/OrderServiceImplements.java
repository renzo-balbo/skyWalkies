package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Order;
import com.mindhub.skywalkies.repositories.OrderRepository;
import com.mindhub.skywalkies.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplements implements OrderService {
    @Autowired
    public OrderRepository orderRepository;

    @Override
    public Order findById(Long id) {
         return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> allOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}

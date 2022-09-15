package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Order;

import java.util.List;

public interface OrderService {
  public Order findById (Long id);
  public List<Order> allOrder();
  public void saveOrder(Order order);
}

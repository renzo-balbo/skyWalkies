package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Order;
import com.mindhub.skywalkies.models.Shoe;
import java.time.LocalDate;
import java.util.Set;

public class OrderDTO {
  private long id;
  private Set<Shoe> shoes;
  private Bill bill;
  private LocalDate localDate;

  public OrderDTO (){}

  public OrderDTO (Order order){
    this.id = order.getId();;
    this.bill = order.getBill();
    this.shoes = order.getShoes();
    this.localDate = order.getLocalDate();
  }

  public long getId() {
    return id;
  }

  public Set<Shoe> getShoes() {
    return shoes;
  }

  public Bill getBill() {
    return bill;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }
}

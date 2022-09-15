package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Order;

import java.time.LocalDate;
import java.util.Set;

public class BillDTO {
  private long id;
  private Set<Order> orders;
  private Client client;
  private boolean payed;
  private LocalDate localDate;
  private double totalAmount;

  public BillDTO() {
  }
  public BillDTO(Bill bill) {
    this.id = bill.getId();
    this.client = bill.getClient();
    this.payed = bill.isPayed();
    this.orders = bill.getOrders();
    this.localDate = bill.getLocalDate();
    this.totalAmount = bill.getTotalAmount();

  }

  public long getId() {
    return id;
  }

  public Set<Order> getOrders() {
    return orders;
  }

  public Client getClient() {
    return client;
  }

  public boolean isPayed() {
    return payed;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public double getTotalAmount() {
    return totalAmount;
  }
}

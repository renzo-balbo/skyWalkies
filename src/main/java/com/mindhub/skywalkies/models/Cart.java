package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;
  @OneToOne(cascade = CascadeType.ALL)
  private Client client;

  @ManyToOne
  @JoinColumn(name = "shoe_id")
  private Shoe shoe;
  @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
  private Set<ClientCart> clientCarts = new HashSet<>();
  private double totalAmount;
  private LocalDate localDate;

  public Cart() {
  }

  public Cart(Client client, double totalAmount, LocalDate localDate) {
    this.client = client;
    this.totalAmount = totalAmount;
    this.localDate = localDate;
  }

  public long getId() {
    return id;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public Set<ClientCart> getClientCarts() {
    return clientCarts;
  }

  public void setClientCarts(Set<ClientCart> clientCarts) {
    this.clientCarts = clientCarts;
  }
}

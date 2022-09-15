package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  private Set<Shoe> shoes = new HashSet<>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "bill_id")
  private Bill bill;
  private LocalDate localDate;

  public Order() {
  }

  public Order(Set<Shoe> shoes, Bill bill, LocalDate localDate) {
    this.shoes = shoes;
    this.bill = bill;
    this.localDate = localDate;
  }

  public long getId() {
    return id;
  }

  public Set<Shoe> getShoes() {
    return shoes;
  }

  public void setShoes(Set<Shoe> shoes) {
    this.shoes = shoes;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public Bill getBill() {
    return bill;
  }

  public void setBill(Bill bill) {
    this.bill = bill;
  }
}

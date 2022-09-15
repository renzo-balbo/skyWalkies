package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Shoe {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;
  @ElementCollection
  @Column(name = "Colors")
  private List<Colors> colors = new ArrayList<>();
  @ElementCollection
  @Column(name = "Size")
  private List<Integer> sizes = new ArrayList<>();
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_id")
  private Order order;
  private int stock;
  private double price;
  private boolean activeShoe;
  private String name;

  public Shoe() {
  }

  public Shoe(String name, List<Colors> colors, int stock, double price, List<Integer> sizes) {
    this.name = name;
    this.colors = colors;
    this.stock = stock;
    this.price = price;
    this.activeShoe = true;
    this.sizes = sizes;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Colors> getColors() {
    return colors;
  }

  public void setColors(List<Colors> colors) {
    this.colors = colors;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isActiveShoe() {
    return activeShoe;
  }

  public void setActiveShoe(boolean activeShoe) {
    this.activeShoe = activeShoe;
  }

  public List<Integer> getSizes() {
    return sizes;
  }

  public void setSizes(List<Integer> sizes) {
    this.sizes = sizes;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}

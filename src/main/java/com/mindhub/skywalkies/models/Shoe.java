package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shoe {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;
  private String name, color;
  private int stock;
  private double price;
  private SizeShoe sizeShoe;
  private boolean activeShoe;

  public Shoe() {
  }

  public Shoe(String name, String color, int stock, double price, SizeShoe sizeShoe, boolean activeShoe) {
    this.name = name;
    this.color = color;
    this.stock = stock;
    this.price = price;
    this.sizeShoe = sizeShoe;
    this.activeShoe = activeShoe;
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

  public String getColors() {
    return color;
  }

  public void setColors(String colors) {
    this.color = colors;
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

  public SizeShoe getSizeShoe() {
    return sizeShoe;
  }

  public void setSizeShoe(SizeShoe sizeShoe) {
    this.sizeShoe = sizeShoe;
  }

  public boolean isActiveShoe() {
    return activeShoe;
  }

  public void setActiveShoe(boolean activeShoe) {
    this.activeShoe = activeShoe;
  }
}

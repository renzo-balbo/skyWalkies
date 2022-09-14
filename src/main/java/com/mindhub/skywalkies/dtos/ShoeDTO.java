package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Shoe;
import com.mindhub.skywalkies.models.SizeShoe;

public class ShoeDTO {
  private long id;
  private String name,color;
  private int stock;
  private double price;
  private SizeShoe sizeShoe;
  private boolean activeShoe;

  public ShoeDTO() {
  }
  public ShoeDTO(Shoe shoe) {
    this.id = shoe.getId();
    this.name = shoe.getName();
    this.color = shoe.getColors();
    this.stock = shoe.getStock();
    this.price = shoe.getPrice();
    this.sizeShoe = shoe.getSizeShoe();
    this.activeShoe = shoe.isActiveShoe();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public int getStock() {
    return stock;
  }

  public double getPrice() {
    return price;
  }

  public SizeShoe getSizeShoe() {
    return sizeShoe;
  }

  public boolean isActiveShoe() {
    return activeShoe;
  }
}

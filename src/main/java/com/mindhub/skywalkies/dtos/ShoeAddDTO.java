package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Colors;
import com.mindhub.skywalkies.models.Shoe;

import java.util.List;

public class ShoeAddDTO {
  private long id;
  private String name;
  private List<Colors> colors;
  private List<Integer> sizes;
  private int stock;
  private double price;
  public ShoeAddDTO(){}
  public ShoeAddDTO(Shoe shoe){
    this.colors = shoe.getColors();
    this.name = shoe.getName();
    this.price = shoe.getPrice();
    this.sizes = shoe.getSizes();
    this.stock = shoe.getStock();
    this.price = shoe.getPrice();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Colors> getColors() {
    return colors;
  }

  public List<Integer> getSizes() {
    return sizes;
  }

  public int getStock() {
    return stock;
  }

  public double getPrice() {
    return price;
  }
}

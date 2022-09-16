package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Product;

import java.util.List;

public class AddProductDTO {
  private  String name;
  private  String colors;
  private  String type;
  private  boolean active;

  private  List<Integer> sizes;
  private  int stock;
  private  double price;

  public AddProductDTO() {
  }

  public AddProductDTO(Product product) {
    this.name = product.getName();
    this.active = product.getActive();
    this.sizes = product.getSize();
    this.colors = product.getColor();
    this.stock = product.getStock();
    this.type = product.getType();
    this.price = product.getPrice();
  }

  public String getName() {
    return name;
  }

  public String getColors() {
    return colors;
  }

  public String getType() {
    return type;
  }

  public Boolean getActive() {
    return active;
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

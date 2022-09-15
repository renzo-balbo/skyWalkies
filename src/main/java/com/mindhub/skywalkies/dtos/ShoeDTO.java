package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.CliOrd;
import com.mindhub.skywalkies.models.Colors;
import com.mindhub.skywalkies.models.Shoe;
import java.util.List;
public class ShoeDTO {
  private long id;
  private String name;
  private List<Colors> colors;
  private List<Integer> sizes;
  private int stock;
  private double price;
  private boolean activeShoe;
  private CliOrd cliOrd;

  public ShoeDTO() {
  }
  public ShoeDTO(Shoe shoe) {
    this.id = shoe.getId();
    this.name = shoe.getName();
    this.colors = shoe.getColors();
    this.sizes = shoe.getSizes();
    this.stock = shoe.getStock();
    this.price = shoe.getPrice();
    this.activeShoe = shoe.isActiveShoe();
    this.cliOrd = shoe.getCliOrd();
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

  public boolean isActiveShoe() {
    return activeShoe;
  }

  public CliOrd getCliOrd() {
    return cliOrd;
  }
}

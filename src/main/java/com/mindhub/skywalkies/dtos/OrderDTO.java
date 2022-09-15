package com.mindhub.skywalkies.dtos;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.CliOrd;
import com.mindhub.skywalkies.models.Shoe;
import java.time.LocalDate;
import java.util.Set;

public class OrderDTO {
  private long id;
  private Set<Shoe> shoes;
  private Bill bill;
  private LocalDate localDate;

  public OrderDTO (){}

  public OrderDTO (CliOrd cliOrd){
    this.id = cliOrd.getId();;
    this.bill = cliOrd.getBill();
    this.shoes = cliOrd.getShoes();
    this.localDate = cliOrd.getLocalDate();
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

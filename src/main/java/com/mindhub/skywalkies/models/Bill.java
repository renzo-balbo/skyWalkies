package com.mindhub.skywalkies.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bill {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;
  @OneToMany(mappedBy = "bill", fetch = FetchType.EAGER)
  private Set<CliOrd> cliOrds = new HashSet<>();
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "client_id")
  private Client client;
  private boolean payed;
  private LocalDate localDate;
  private double totalAmount;

  public Bill() {
  }

  public Bill(Set<CliOrd> cliOrds, Client client, boolean payed, LocalDate localDate, double totalAmount) {
    this.cliOrds = cliOrds;
    this.client = client;
    this.payed = false;
    this.localDate = localDate;
    this.totalAmount = totalAmount;
  }

  public long getId() {
    return id;
  }

  public Set<CliOrd> getCliOrd() {
    return cliOrds;
  }

  public void setCliOrd(Set<CliOrd> cliOrds) {
    this.cliOrds = cliOrds;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public boolean isPayed() {
    return payed;
  }

  public void setPayed(boolean payed) {
    this.payed = payed;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }
}

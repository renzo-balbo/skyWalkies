package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.CliOrd;

import java.util.List;

public interface OrderService {
  public CliOrd findById (Long id);
  public List<CliOrd> allOrder();
  public void saveOrder(CliOrd cliOrd);
}

package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Bill;

import java.util.List;

public interface BillService {
  public Bill findById (Long id);
  public List<Bill> allBills();
  public void saveBill(Bill bill);
}

package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.repositories.BillRepository;
import com.mindhub.skywalkies.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImplements implements BillService {
  @Autowired
  private BillRepository billRepository;
  @Override
  public Bill findById(Long id) {
    return billRepository.findById(id).orElse(null);
  }

  @Override
  public List<Bill> allBills() {
    return billRepository.findAll();
  }

  @Override
  public void saveBill(Bill bill) {
    billRepository.save(bill);
  }
}

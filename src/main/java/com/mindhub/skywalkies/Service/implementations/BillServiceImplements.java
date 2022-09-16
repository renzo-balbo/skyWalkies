package com.mindhub.skywalkies.Service.implementations;

import com.mindhub.skywalkies.Service.BillService;
import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BillServiceImplements implements BillService {
    @Autowired
    public BillRepository billRepository;

    @Override
    public void saveBill(Bill bill){billRepository.save(bill);}

}

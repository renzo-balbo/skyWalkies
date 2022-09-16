package com.mindhub.skywalkies.Service;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BillService {

    List<Bill> getAllBills();

    void saveBill(Bill bill);
}

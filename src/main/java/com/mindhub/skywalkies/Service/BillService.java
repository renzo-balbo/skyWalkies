package com.mindhub.skywalkies.Service;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface BillService {

    void saveBill(Bill bill);
}

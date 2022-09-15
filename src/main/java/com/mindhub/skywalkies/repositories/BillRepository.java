package com.mindhub.skywalkies.repositories;

import com.mindhub.skywalkies.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}

package com.mindhub.skywalkies.repositories;

import com.mindhub.skywalkies.models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
  Shoe findByName(String name);
}

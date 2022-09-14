package com.mindhub.skywalkies.repositories;

import com.mindhub.skywalkies.models.Colors;
import com.mindhub.skywalkies.models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
  Shoe findByName(String name);
}

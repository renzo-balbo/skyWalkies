package com.mindhub.skywalkies.repositories;

import com.mindhub.skywalkies.models.Bill;
import com.mindhub.skywalkies.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

}



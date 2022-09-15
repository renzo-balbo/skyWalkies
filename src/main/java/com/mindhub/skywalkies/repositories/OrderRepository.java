package com.mindhub.skywalkies.repositories;

import com.mindhub.skywalkies.models.CliOrd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<CliOrd, Long> {

}

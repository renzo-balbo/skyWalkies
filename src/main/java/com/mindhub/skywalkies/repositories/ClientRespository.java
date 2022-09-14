package com.mindhub.skywalkies.repositories;

import com.mindhub.skywalkies.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRespository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}

package com.mindhub.skywalkies.repositories;

import com.mindhub.skywalkies.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface UserRespository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

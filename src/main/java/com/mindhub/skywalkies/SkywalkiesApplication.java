package com.mindhub.skywalkies;

import com.mindhub.skywalkies.models.Avatar;
import com.mindhub.skywalkies.models.Client;


import com.mindhub.skywalkies.repositories.AvatarRepository;
import com.mindhub.skywalkies.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SkywalkiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkywalkiesApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(ClientRepository clientRepository, AvatarRepository avatarRepository) {
        return (args) -> {
            Client client1 = new Client("renzo", "balbo", "renzobalbo@skywalkies.com.ar","skywalkies", true);
            Avatar avatar1 = new Avatar(1,1,1,1,1);
            clientRepository.save(client1);
            avatarRepository.save(avatar1);

        };
    }
}

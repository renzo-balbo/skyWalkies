package com.mindhub.skywalkies;

import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.repositories.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
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
public CommandLineRunner initData(ClientRespository clientRespository) {
		return (args) -> {
			Client clientTest1 = new Client("El capi", "Balbo", "Capi@mindhub.com", "skywalkies");
			clientRespository.save(clientTest1);
		};
	}
}

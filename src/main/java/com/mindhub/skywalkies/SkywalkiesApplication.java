package com.mindhub.skywalkies;

import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Shoe;
import com.mindhub.skywalkies.models.SizeShoe;
import com.mindhub.skywalkies.repositories.ClientRespository;
import com.mindhub.skywalkies.repositories.ShoeRepository;
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
public CommandLineRunner initData(ClientRespository clientRespository, ShoeRepository shoeRepository) {
		return (args) -> {
			Client clientTest1 = new Client("El capi", "Balbo", "Capi@mindhub.com", "skywalkies");
			Shoe shoeTest1 = new Shoe("Air Force Adri", "Blancas", 5, 999, SizeShoe.US11_5);
			clientRespository.save(clientTest1);
			shoeRepository.save(shoeTest1);
		};
	}
}

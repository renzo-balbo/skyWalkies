package com.mindhub.skywalkies;

import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Shoe;
import com.mindhub.skywalkies.repositories.ClientRespository;
import com.mindhub.skywalkies.repositories.ShoeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;
import static com.mindhub.skywalkies.models.Colors.RED;
import static com.mindhub.skywalkies.models.Colors.WHITE;

@SpringBootApplication
public class SkywalkiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(SkywalkiesApplication.class, args);
	}
	@Bean
public CommandLineRunner initData(ClientRespository clientRespository, ShoeRepository shoeRepository) {
		return (args) -> {
			Client clientTest1 = new Client("El capi", "Balbo", "Capi@mindhub.com", "skywalkies");
			Shoe shoeTest1 = new Shoe("Air Force Adri", Arrays.asList(WHITE,RED), 5, 999, Arrays.asList(7,8,9,10,11));
			clientRespository.save(clientTest1);
			shoeRepository.save(shoeTest1);
		};
	}
}

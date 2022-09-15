package com.mindhub.skywalkies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
public class SkywalkiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(SkywalkiesApplication.class, args);
	}
	@Bean
public CommandLineRunner initData(ClientRespository clientRespository, ShoeRepository shoeRepository, AvatarRepository avatarRepository) {
		return (args) -> {

		};
	}

}

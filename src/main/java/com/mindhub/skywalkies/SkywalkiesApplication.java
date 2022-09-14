package com.mindhub.skywalkies;

import com.mindhub.skywalkies.models.Avatar;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Shoe;
import com.mindhub.skywalkies.repositories.AvatarRepository;
import com.mindhub.skywalkies.repositories.ClientRespository;
import com.mindhub.skywalkies.repositories.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

import static com.mindhub.skywalkies.models.Colors.*;

@SpringBootApplication
public class SkywalkiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(SkywalkiesApplication.class, args);
	}
	@Bean
public CommandLineRunner initData(ClientRespository clientRespository, ShoeRepository shoeRepository, AvatarRepository avatarRepository) {
		return (args) -> {
			//CLIENTS//
			Client clientTest1 = new Client("Renzo", "Balbo", "elCapi@skywalkies.com.ar", passwordEncoder.encode("skywalkies"));
			Client clientTest2 = new Client("Adro", "Balbo", "adroBalbo@hotmail.com.ar", passwordEncoder.encode("skywalkies"));
			//CLIENTS//

			//SHOES//
			Shoe shoeTest1 = new Shoe("Air Force Renzo", Arrays.asList(WHITE,RED), 5, 999, Arrays.asList(7,8,9,10,11));
			Shoe shoeTest2 = new Shoe("Air Force Adro", Arrays.asList(WHITE,RED), 5, 999, Arrays.asList(7,8,9,10,11));
			Shoe shoeTest3 = new Shoe("Air Force Franco", Arrays.asList(WHITE,YELLOW), 5, 999, Arrays.asList(7,8,9,10,11));
			Shoe shoeTest4 = new Shoe("Air Force Alu", Arrays.asList(WHITE,BROWN), 5, 999, Arrays.asList(7,8,9,10,11));
			Shoe shoeTest5 = new Shoe("Air Force TomiG", Arrays.asList(WHITE,BLUE), 5, 999, Arrays.asList(7,8,9,10,11));
			Shoe shoeTest6 = new Shoe("Air Force Adri", Arrays.asList(WHITE,BLACK), 5, 999, Arrays.asList(7,8,9,10,11));
			//SHOES//
			//AVATAR//
			Avatar avatarTest1 = new Avatar(1,1,1,1,1);
			Avatar avatarTest2 = new Avatar(2,2,2,2,2);
			Avatar avatarTest3 = new Avatar(3,3,3,3,3);
			Avatar avatarTest4 = new Avatar(4,4,4,4,4);
			Avatar avatarTest5 = new Avatar(5,5,5,5,5);
			Avatar avatarTest6 = new Avatar(6,6,6,6,6);
			//AVATAR//

			//REPOSITORIES//
			clientRespository.save(clientTest1);
			clientRespository.save(clientTest2);
			shoeRepository.save(shoeTest1);
			shoeRepository.save(shoeTest2);
			shoeRepository.save(shoeTest3);
			shoeRepository.save(shoeTest4);
			shoeRepository.save(shoeTest5);
			shoeRepository.save(shoeTest6);
			avatarRepository.save(avatarTest1);
			avatarRepository.save(avatarTest2);
			avatarRepository.save(avatarTest3);
			avatarRepository.save(avatarTest4);
			avatarRepository.save(avatarTest5);
			avatarRepository.save(avatarTest6);


			//REPOSITORIES//
		};
	}
	@Autowired
	public PasswordEncoder passwordEncoder;
}

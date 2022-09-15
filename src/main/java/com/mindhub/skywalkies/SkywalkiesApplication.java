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

import javax.persistence.GeneratedValue;
import java.util.Arrays;
import java.util.List;

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
			Shoe shoe1 = new Shoe("LV_NIKE_LOW_SOTHEBYS", List.of(BROWN, WHITE), 10,1299, Arrays.asList(7,8,9,10,11));
			Shoe shoe2 = new Shoe("LV-NIKE-AFONE-HIGH-PLUS-A3", List.of(WHITE), 18,1099, Arrays.asList(8,9,10,11));
			Shoe shoe3 = new Shoe("LV-NIKE-AFONE-HIGH-PLUS-E", List.of(WHITE, BROWN), 18,1099, Arrays.asList(9,10,11));
			Shoe shoe4 = new Shoe("LV-NIKE-AFONE-HIGH-PLUS-R", List.of(VIOLET, YELLOW), 7,799, Arrays.asList(8,9,10,11));
			Shoe shoe5 = new Shoe("NIKE-LV-AFONE-HIGH-D", List.of(BLACK), 23,999, Arrays.asList(7,8,9,10));
			Shoe shoe6 = new Shoe("NIKE-LV-HIGH_03", List.of(WHITE), 18,1199, Arrays.asList(8,9,10,11));
			Shoe shoe7 = new Shoe("NIKE-LV-HIGH_06", List.of(WHITE, WITHDRAWS), 5,1699, Arrays.asList(10,11));
			Shoe shoe8 = new Shoe("NIKE-LV-LOW_01", List.of(BLACK), 13,899, Arrays.asList(8,10,11));
			Shoe shoe9 = new Shoe("NIKE-LV-LOW_02", List.of(GOLD), 4,2700, Arrays.asList(8,9,11));
			Shoe shoe10 = new Shoe("NIKE-LV-LOW_04", List.of(WHITE), 18,1099, Arrays.asList(8,9,10,11));
			Shoe shoe11 = new Shoe("NIKE-LV-LOW_07", List.of(WHITE, RED), 28,899, Arrays.asList(7,8,9,10,11));
			Shoe shoe12 = new Shoe("NIKE-LV-LOW_08", List.of(WHITE, GREEN), 25,899, Arrays.asList(7,8,9,10,11));
			Shoe shoe13 = new Shoe("NIKE-LV-LOW_09", List.of(WHITE, BLUE), 28,899, Arrays.asList(7,8,9,10,11));
			Shoe shoe14 = new Shoe("NIKE-LV-LOW_10", List.of(WHITE, BLACK), 30,899, Arrays.asList(7,8,9,10,11));
			Shoe shoe15 = new Shoe("NIKE-LV-LOW_11", List.of(WHITE, ORANGE), 21,999, Arrays.asList(8,9,10,11));
			Shoe shoe16 = new Shoe("NIKE-LV-LOW_12", List.of(WHITE, VIOLET), 18,999, Arrays.asList(8,9,10,11));
			Shoe shoe17 = new Shoe("NIKE-LV-LOW_13", List.of(WHITE, YELLOW), 17,999, Arrays.asList(8,9,10,11));
			Shoe shoe18 = new Shoe("NIKE-LV-LOW_20", List.of(LIGHTBLUE, WHITE), 15,1099, Arrays.asList(7,8,9,11));
			Shoe shoe19 = new Shoe("NIKE-LV-LOW_21", List.of(RED, WHITE), 18,1099, Arrays.asList(8,9,10,11));
			Shoe shoe20 = new Shoe("NIKE-LV-LOW_22", List.of(GREEN, WHITE), 18,1099, Arrays.asList(9,10,11,12));
			Shoe shoe21 = new Shoe("NIKE-LV-LOW_23", List.of(BLUE, WHITE), 17,1099, Arrays.asList(7,8,9,10,11));
			Shoe shoe22 = new Shoe("NIKE-LV-LOW_24", List.of(BLACK, WHITE), 24,999, Arrays.asList(7,8,9,10,11,12));
			Shoe shoe23 = new Shoe("NIKE-LV-LOW_25", List.of(ORANGE,WHITE), 11,1099, Arrays.asList(8,9,11));
			Shoe shoe24 = new Shoe("NIKE-LV-LOW_26", List.of(VIOLET,WHITE), 13,1099, Arrays.asList(8,9,10,11));
			Shoe shoe25 = new Shoe("NIKE-LV-LOW_27", List.of(YELLOW, WHITE), 12,1099, Arrays.asList(8,10,11));
			Shoe shoe26 = new Shoe("NIKE-LV-LOW_A", List.of(BROWN, WHITE), 10,1199, Arrays.asList(8,9,10,11));
			Shoe shoe27 = new Shoe("NIKE-LV-LOW_B", List.of(BROWN, WHITE, BLACK), 11,1299, Arrays.asList(7,8,9,10,11));
			Shoe shoe28 = new Shoe("NIKE-LV-LOW_C", List.of(BROWN, WHITE, PINK), 6,1499, Arrays.asList(7,8,11));
			Shoe shoe29 = new Shoe("NIKE-LV-LOW_F", List.of(BROWN), 8,1399, Arrays.asList(9,10,11));
			Shoe shoe30 = new Shoe("NIKE-LV-LOW_G", List.of(WHITE, WITHDRAWS), 7,1799, Arrays.asList(8,9,10));
			Shoe shoe31 = new Shoe("NIKE-LV-LOW_H", List.of(WHITE, BLACK), 16,1050, Arrays.asList(8,9,10,11));
			Shoe shoe32 = new Shoe("NIKE-LV-LOW_I", List.of(BROWN, BLACK), 10,999, Arrays.asList(8,9,10,11));
			Shoe shoe33 = new Shoe("NIKE-LV-LOW_J", List.of(BLUE, GOLD, BLACK), 5,1599, Arrays.asList(9,10,11));
			Shoe shoe34 = new Shoe("NIKE-LV-LOW_K", List.of(YELLOW, GREEN, BLACK), 7,1199, Arrays.asList(8,9,10,11));
			Shoe shoe35 = new Shoe("NIKE-LV-LOW_L", List.of(RED, BLUE, BLACK), 10,1299, Arrays.asList(8,9,10,11));
			Shoe shoe36 = new Shoe("NIKE-LV-LOW_P", List.of(WHITE, RED), 28,999, Arrays.asList(7,8,9,10,11,12));
			Shoe shoe37 = new Shoe("NIKE-LV-LOW_Q", List.of(WHITE, BLUE), 18,1099, Arrays.asList(7,9,10,11));
			Shoe shoe38 = new Shoe("NIKE-LV-LOW_S", List.of(WHITE, RED, BLUE), 14,1399, Arrays.asList(8,9,10,11));
			Shoe shoe39 = new Shoe("NIKE-LV-LOW_T2", List.of(BLUE, YELLOW, BLACK), 11,1399, Arrays.asList(8,9,10,11));
			Shoe shoe40 = new Shoe("NIKE-LV-LOW_tricolor", List.of(BLACK, WHITE, YELLOW), 3,2400, Arrays.asList(9,10));
			Shoe shoe41 = new Shoe("NIKE-LV-LOW_U", List.of(YELLOW, GREEN, BLACK), 15,1199, Arrays.asList(8,9,10,11));
			Shoe shoe42 = new Shoe("NIKE-LV-LOW_V", List.of(RED, YELLOW, BLACK, BLUE), 14,1399, Arrays.asList(8,9,10,11));
			Shoe shoe43 = new Shoe("NIKE-LV-LOW_W", List.of(GREEN, BLACK), 18,1199, Arrays.asList(8,9,10,11));
			Shoe shoe44 = new Shoe("NIKE-LV-LOW_X", List.of(GREEN, BLACK, WHITE), 18,1299, Arrays.asList(8,9,10,11));
			Shoe shoe45 = new Shoe("NIKE-LV-LOW_Y", List.of(WHITE), 23,1050, Arrays.asList(8,9,10,11));
			Shoe shoe46 = new Shoe("NIKE-LV-LOW_Z", List.of(WHITE, PINK), 17,1099, Arrays.asList(8,9,10,11));
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
			shoeRepository.save(shoe1);
			shoeRepository.save(shoe2);
			shoeRepository.save(shoe3);
			shoeRepository.save(shoe4);
			shoeRepository.save(shoe5);
			shoeRepository.save(shoe6);
			shoeRepository.save(shoe7);
			shoeRepository.save(shoe8);
			shoeRepository.save(shoe9);
			shoeRepository.save(shoe10);
			shoeRepository.save(shoe11);
			shoeRepository.save(shoe12);
			shoeRepository.save(shoe13);
			shoeRepository.save(shoe14);
			shoeRepository.save(shoe15);
			shoeRepository.save(shoe16);
			shoeRepository.save(shoe17);
			shoeRepository.save(shoe18);
			shoeRepository.save(shoe19);
			shoeRepository.save(shoe20);
			shoeRepository.save(shoe21);
			shoeRepository.save(shoe22);
			shoeRepository.save(shoe23);
			shoeRepository.save(shoe24);
			shoeRepository.save(shoe25);
			shoeRepository.save(shoe26);
			shoeRepository.save(shoe27);
			shoeRepository.save(shoe28);
			shoeRepository.save(shoe29);
			shoeRepository.save(shoe30);
			shoeRepository.save(shoe31);
			shoeRepository.save(shoe32);
			shoeRepository.save(shoe33);
			shoeRepository.save(shoe34);
			shoeRepository.save(shoe35);
			shoeRepository.save(shoe36);
			shoeRepository.save(shoe37);
			shoeRepository.save(shoe38);
			shoeRepository.save(shoe39);
			shoeRepository.save(shoe40);
			shoeRepository.save(shoe41);
			shoeRepository.save(shoe42);
			shoeRepository.save(shoe43);
			shoeRepository.save(shoe44);
			shoeRepository.save(shoe45);
			shoeRepository.save(shoe46);
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

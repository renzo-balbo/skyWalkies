package com.mindhub.skywalkies;

import com.mindhub.skywalkies.models.*;


import com.mindhub.skywalkies.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.mindhub.skywalkies.models.ShoeColors.*;


@SpringBootApplication
public class SkywalkiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkywalkiesApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(ClientRepository clientRepository, AvatarRepository avatarRepository, BillRepository billRepository, ProductRepository productRepository, Ordered_ProductRepository ordered_productRepository, Client_OrderRepository client_orderRepository) {
        return (args) -> {

            //PRODUCTOS//
            Product productShoe1  = new Product("LV_NIKE_LOW_SOTHEBYS",List.of(BROWN, WITHE), "Sneaker", true, List.of(8,9,10,11), 15, 299);
            Product productShoe2  = new Product("LV-NIKE-AFONE-HIGH-PLUS-A3", List.of(WITHE), "Sneaker", true, List.of(7,8,10,11), 15, 350);
            Product productShoe3  = new Product("LV-NIKE-AFONE-HIGH-PLUS-E", List.of(BROWN, WITHE), "Sneaker", true, List.of(8,9,10,11), 15, 299);
            Product productShoe4  = new Product("LV-NIKE-AFONE-HIGH-PLUS-R", List.of(PURPLE, YELLOW), "Sneaker", true, List.of(9,10,11), 10, 399);
            Product productShoe5  = new Product("NIKE-LV-AFONE-HIGH-D", List.of(BLACK), "Sneaker", true, List.of(7,8,9,10,11), 25, 199);
            Product productShoe6  = new Product("NIKE-LV-HIGH_03", List.of(WITHE), "Sneaker", true, List.of(7,8,9,10), 25, 230);
            Product productShoe7  = new Product("NIKE-LV-HIGH_06", List.of(WITHE, WITHDRAWS), "Sneaker", true, List.of(8,9,11), 12, 499);
            Product productShoe8  = new Product("NIKE-LV-LOW_01", List.of(BLACK), "Sneaker", true, List.of(7,8,9,10,11), 30, 150);
            Product productShoe9  = new Product("NIKE-LV-LOW_02", List.of(WITHE), "Sneaker", true, List.of(7,9,10,11), 27, 199);
            Product productShoe10 = new Product("NIKE-LV-LOW_04", List.of(GOLD), "Sneaker", true, List.of(9,10), 3, 1299);
            Product productShoe11 = new Product("NIKE-LV-LOW_07", List.of(RED, WITHE), "Sneaker", true, List.of(7,8,9,10,11), 20, 250);
            Product productShoe12 = new Product("NIKE-LV-LOW_08", List.of(GREEN, WITHE), "Sneaker", true, List.of(8,10,11), 20, 250);
            Product productShoe13 = new Product("NIKE-LV-LOW_09", List.of(BLUE, WITHE), "Sneaker", true, List.of(8,9,10,11), 20, 250);
            Product productShoe14 = new Product("NIKE-LV-LOW_10", List.of(BLACK, WITHE), "Sneaker", true, List.of(7,9,10,11), 20, 250);
            Product productShoe15 = new Product("NIKE-LV-LOW_11", List.of(ORANGE, WITHE), "Sneaker", true, List.of(8,9,10,11), 18, 250);
            Product productShoe16 = new Product("NIKE-LV-LOW_12", List.of(PURPLE, WITHE), "Sneaker", true, List.of(8,10,11), 14, 250);
            Product productShoe17 = new Product("NIKE-LV-LOW_13", List.of(YELLOW, WITHE), "Sneaker", true, List.of(8,9,10), 16, 250);
            Product productShoe18 = new Product("NIKE-LV-LOW_20", List.of(LIGHTBLUE, WITHE), "Sneaker", true, List.of(7,8,9,10,11), 15, 299);
            Product productShoe19 = new Product("NIKE-LV-LOW_21", List.of(RED, WITHE), "Sneaker", true, List.of(7,8,9,11), 16, 299);
            Product productShoe20 = new Product("NIKE-LV-LOW_22", List.of(GREEN, WITHE), "Sneaker", true, List.of(8,9,10,11), 15, 299);
            Product productShoe21 = new Product("NIKE-LV-LOW_23", List.of(BLUE, WITHE), "Sneaker", true, List.of(7,8,10,11), 17, 299);
            Product productShoe22 = new Product("NIKE-LV-LOW_24", List.of(BLACK, WITHE), "Sneaker", true, List.of(7,9,10,11), 19, 299);
            Product productShoe23 = new Product("NIKE-LV-LOW_25", List.of(ORANGE, WITHE), "Sneaker", true, List.of(7,8,9,10), 11, 299);
            Product productShoe24 = new Product("NIKE-LV-LOW_26", List.of(PURPLE, WITHE), "Sneaker", true, List.of(7,8,9,10,11), 13, 299);
            Product productShoe25 = new Product("NIKE-LV-LOW_27", List.of(YELLOW, WITHE), "Sneaker", true, List.of(7,8,9,10,11), 12, 299);
            Product productShoe26 = new Product("NIKE-LV-LOW_A", List.of(BROWN, WITHE), "Sneaker", true, List.of(8,9,10,11), 13, 250);
            Product productShoe27 = new Product("NIKE-LV-LOW_B", List.of(BROWN, WITHE, BLACK), "Sneaker", true, List.of(9,10,11), 15, 269);
            Product productShoe28 = new Product("NIKE-LV-LOW_C", List.of(BROWN, WITHE, PINK), "Sneaker", true, List.of(8,10,11), 15, 300);
            Product productShoe29 = new Product("NIKE-LV-LOW_F", List.of(BROWN, BLACK), "Sneaker", true, List.of(8,9,11), 12, 279);
            Product productShoe30 = new Product("NIKE-LV-LOW_G", List.of(WITHE, WITHDRAWS), "Sneaker", true, List.of(8,9,10), 10, 499);
            Product productShoe31 = new Product("NIKE-LV-LOW_H", List.of(WITHE, BLACK), "Sneaker", true, List.of(8,9,10,11), 20, 250);
            Product productShoe32 = new Product("NIKE-LV-LOW_I", List.of(BLACK, BROWN), "Sneaker", true, List.of(9,10,11), 11, 320);
            Product productShoe33 = new Product("NIKE-LV-LOW_J", List.of(BLUE,YELLOW, BLACK), "Sneaker", true, List.of(8,10,11), 10, 420);
            Product productShoe34 = new Product("NIKE-LV-LOW_K", List.of(YELLOW,GREEN, BLACK), "Sneaker", true, List.of(8,9,10), 13, 330);
            Product productShoe35 = new Product("NIKE-LV-LOW_L", List.of(RED,BLUE,YELLOW, BLACK), "Sneaker", true, List.of(8,9,10,11), 15, 310);
            Product productShoe36 = new Product("NIKE-LV-LOW_P",  List.of(WITHE, RED), "Sneaker", true, List.of(8,9,10,11), 20, 399);
            Product productShoe37 = new Product("NIKE-LV-LOW_Q",  List.of(BLUE, WITHE), "Sneaker", true, List.of(8,9,10,11), 15, 189);
            Product productShoe38 = new Product("NIKE-LV-LOW_S",  List.of(RED,WITHE,BLUE), "Sneaker", true, List.of(9,10,11), 14, 350);
            Product productShoe39 = new Product("NIKE-LV-LOW_T2",  List.of(BLUE,YELLOW, BLACK), "Sneaker", true, List.of(10,11), 12, 229);
            Product productShoe40 = new Product("NIKE-LV-LOW_tricolor",  List.of(BLACK, WITHE, YELLOW), "Sneaker", true, List.of(8,10), 7, 899);
            Product productShoe41 = new Product("NIKE-LV-LOW_U", List.of(YELLOW,GREEN, BLACK), "Sneaker", true, List.of(8,9,10,11), 13, 350);
            Product productShoe42 = new Product("NIKE-LV-LOW_V", List.of(RED,BLACK,YELLOW, BLUE), "Sneaker", true, List.of(8,9,10,11), 15, 310);
            Product productShoe43 = new Product("NIKE-LV-LOW_W", List.of(GREEN, BLACK), "Sneaker", true, List.of(9,10,11), 17, 199);
            Product productShoe44 = new Product("NIKE-LV-LOW_X", List.of(GREEN, BLACK, WITHE), "Sneaker", true, List.of(8,9,10), 15, 240);
            Product productShoe45 = new Product("NIKE-LV-LOW_Y", List.of(WITHE), "Sneaker", true, List.of(7,8,9,10,11), 15, 299);
            Product productShoe46 = new Product("NIKE-LV-LOW_Z", List.of(WITHE, PINK), "Sneaker", true, List.of(8,9,10,11), 15, 170);
            //PRODUCTOS//




            //BILLS//
            Bill bill1 = new Bill( LocalDateTime.now(), true, 992.23);
            //BILLS//
            Avatar avatar1 = new Avatar(1,2,1,5,3);
            //CLIENTES//
            Client client1 = new Client("renzo", "balbo", "renzobalbo@skywalkies.com.ar", passwordEncoder.encode("skywalkies"), true, bill1, avatar1);

            //CLIENTES//


            //ORDENES//
            Ordered_product ordered_product1= new Ordered_product(1,1,productShoe1);
            //ORDENES//
            Client_order order1 = new Client_order(ordered_product1, bill1.getId());


            clientRepository.save(client1);
            avatarRepository.save(avatar1);
            billRepository.save(bill1);

            ordered_productRepository.save(ordered_product1);

            client_orderRepository.save(order1);



            productRepository.save(productShoe1);
            productRepository.save(productShoe2);
            productRepository.save(productShoe3);
            productRepository.save(productShoe4);
            productRepository.save(productShoe5);
            productRepository.save(productShoe6);
            productRepository.save(productShoe7);
            productRepository.save(productShoe8);
            productRepository.save(productShoe9);
            productRepository.save(productShoe10);
            productRepository.save(productShoe11);
            productRepository.save(productShoe12);
            productRepository.save(productShoe13);
            productRepository.save(productShoe14);
            productRepository.save(productShoe15);
            productRepository.save(productShoe16);
            productRepository.save(productShoe17);
            productRepository.save(productShoe18);
            productRepository.save(productShoe19);
            productRepository.save(productShoe20);
            productRepository.save(productShoe21);
            productRepository.save(productShoe22);
            productRepository.save(productShoe23);
            productRepository.save(productShoe24);
            productRepository.save(productShoe25);
            productRepository.save(productShoe26);
            productRepository.save(productShoe27);
            productRepository.save(productShoe28);
            productRepository.save(productShoe29);
            productRepository.save(productShoe30);
            productRepository.save(productShoe31);
            productRepository.save(productShoe32);
            productRepository.save(productShoe33);
            productRepository.save(productShoe34);
            productRepository.save(productShoe35);
            productRepository.save(productShoe36);
            productRepository.save(productShoe37);
            productRepository.save(productShoe38);
            productRepository.save(productShoe39);
            productRepository.save(productShoe40);
            productRepository.save(productShoe41);
            productRepository.save(productShoe42);
            productRepository.save(productShoe43);
            productRepository.save(productShoe44);
            productRepository.save(productShoe45);
            productRepository.save(productShoe46);




            //bill1.addClient_order(order1);
            client_orderRepository.save(order1);



        };
    }
    @Autowired
    public PasswordEncoder passwordEncoder;
}

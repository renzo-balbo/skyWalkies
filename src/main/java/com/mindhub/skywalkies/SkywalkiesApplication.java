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


@SpringBootApplication
public class SkywalkiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkywalkiesApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(ClientRepository clientRepository, AvatarRepository avatarRepository, BillRepository billRepository, ProductRepository productRepository, Ordered_ProductRepository ordered_productRepository, Client_OrderRepository client_orderRepository) {
        return (args) -> {

            //PRODUCTOS//

            Product productShoe1  = new Product("LV_NIKE_LOW_SOTHEBYS", "Brown and withe", "Sneaker", true, List.of(8,9,10,11), 15, 299);
            Product productShoe2  = new Product("LV-NIKE-AFONE-HIGH-PLUS-A3", "Withe", "Sneaker", true, List.of(7,8,10,11), 15, 350);
            Product productShoe3  = new Product("LV-NIKE-AFONE-HIGH-PLUS-E", "Brown and withe", "Sneaker", true, List.of(8,9,10,11), 15, 299);
            Product productShoe4  = new Product("LV-NIKE-AFONE-HIGH-PLUS-R", "Purple and yellow", "Sneaker", true, List.of(9,10,11), 10, 399);
            Product productShoe5  = new Product("NIKE-LV-AFONE-HIGH-D", "Black", "Sneaker", true, List.of(7,8,9,10,11), 25, 199);
            Product productShoe6  = new Product("NIKE-LV-HIGH_03", "Withe", "Sneaker", true, List.of(7,8,9,10), 25, 230);
            Product productShoe7  = new Product("NIKE-LV-HIGH_06", "White with draws", "Sneaker", true, List.of(8,9,11), 12, 499);
            Product productShoe8  = new Product("NIKE-LV-LOW_01", "Black", "Sneaker", true, List.of(7,8,9,10,11), 30, 150);
            Product productShoe9  = new Product("NIKE-LV-LOW_02", "Withe", "Sneaker", true, List.of(7,9,10,11), 27, 199);
            Product productShoe10 = new Product("NIKE-LV-LOW_04", "Gold", "Sneaker", true, List.of(9,10), 3, 1299);
            Product productShoe11 = new Product("NIKE-LV-LOW_07", "Red and withe", "Sneaker", true, List.of(7,8,9,10,11), 20, 250);
            Product productShoe12 = new Product("NIKE-LV-LOW_08", "Green and withe", "Sneaker", true, List.of(8,10,11), 20, 250);
            Product productShoe13 = new Product("NIKE-LV-LOW_09", "Blue and withe", "Sneaker", true, List.of(8,9,10,11), 20, 250);
            Product productShoe14 = new Product("NIKE-LV-LOW_10", "Black and withe", "Sneaker", true, List.of(7,9,10,11), 20, 250);
            Product productShoe15 = new Product("NIKE-LV-LOW_11", "Orange and withe", "Sneaker", true, List.of(8,9,10,11), 18, 250);
            Product productShoe16 = new Product("NIKE-LV-LOW_12", "Purple and withe", "Sneaker", true, List.of(8,10,11), 14, 250);
            Product productShoe17 = new Product("NIKE-LV-LOW_13", "Yellow and withe", "Sneaker", true, List.of(8,9,10), 16, 250);
            Product productShoe18 = new Product("NIKE-LV-LOW_20", "LightBlue and white", "Sneaker", true, List.of(7,8,9,10,11), 15, 299);
            Product productShoe19 = new Product("NIKE-LV-LOW_21", "Red and withe", "Sneaker", true, List.of(7,8,9,11), 16, 299);
            Product productShoe20 = new Product("NIKE-LV-LOW_22", "Green and withe", "Sneaker", true, List.of(8,9,10,11), 15, 299);
            Product productShoe21 = new Product("NIKE-LV-LOW_23", "Blue and white", "Sneaker", true, List.of(7,8,10,11), 17, 299);
            Product productShoe22 = new Product("NIKE-LV-LOW_24", "Black and white", "Sneaker", true, List.of(7,9,10,11), 19, 299);
            Product productShoe23 = new Product("NIKE-LV-LOW_25", "Orange and white", "Sneaker", true, List.of(7,8,9,10), 11, 299);
            Product productShoe24 = new Product("NIKE-LV-LOW_26", "Purple and white", "Sneaker", true, List.of(7,8,9,10,11), 13, 299);
            Product productShoe25 = new Product("NIKE-LV-LOW_27", "Yellow and white", "Sneaker", true, List.of(7,8,9,10,11), 12, 299);
            Product productShoe26 = new Product("NIKE-LV-LOW_A", "Brown and withe", "Sneaker", true, List.of(8,9,10,11), 13, 250);
            Product productShoe27 = new Product("NIKE-LV-LOW_B", "Brown, withe and black", "Sneaker", true, List.of(9,10,11), 15, 269);
            Product productShoe28 = new Product("NIKE-LV-LOW_C", "Brown, withe and pink", "Sneaker", true, List.of(8,10,11), 15, 300);
            Product productShoe29 = new Product("NIKE-LV-LOW_F", "Brown and black", "Sneaker", true, List.of(8,9,11), 12, 279);
            Product productShoe30 = new Product("NIKE-LV-LOW_G", "White with draws", "Sneaker", true, List.of(8,9,10), 10, 499);
            Product productShoe31 = new Product("NIKE-LV-LOW_H", "Withe and black", "Sneaker", true, List.of(8,9,10,11), 20, 250);
            Product productShoe32 = new Product("NIKE-LV-LOW_I", "Brown and black", "Sneaker", true, List.of(9,10,11), 11, 320);
            Product productShoe33 = new Product("NIKE-LV-LOW_J", "Blue, yellow and black", "Sneaker", true, List.of(8,10,11), 10, 420);
            Product productShoe34 = new Product("NIKE-LV-LOW_K", "Yellow, green and black", "Sneaker", true, List.of(8,9,10), 13, 330);
            Product productShoe35 = new Product("NIKE-LV-LOW_L", "Red, blue, yellow and black", "Sneaker", true, List.of(8,9,10,11), 15, 310);
            Product productShoe36 = new Product("NIKE-LV-LOW_P", "Withe and red", "Sneaker", true, List.of(8,9,10,11), 20, 399);
            Product productShoe37 = new Product("NIKE-LV-LOW_Q", "Blue and withe", "Sneaker", true, List.of(8,9,10,11), 15, 189);
            Product productShoe38 = new Product("NIKE-LV-LOW_S", "Red, white and blue", "Sneaker", true, List.of(9,10,11), 14, 350);
            Product productShoe39 = new Product("NIKE-LV-LOW_T2", "Blue, yellow and black", "Sneaker", true, List.of(10,11), 12, 229);
            Product productShoe40 = new Product("NIKE-LV-LOW_tricolor", "Black, white and yellow", "Sneaker", true, List.of(8,10), 7, 899);
            Product productShoe41 = new Product("NIKE-LV-LOW_U", "Yellow, green and black", "Sneaker", true, List.of(8,9,10,11), 13, 350);
            Product productShoe42 = new Product("NIKE-LV-LOW_V", "Red, black, yellow and blue", "Sneaker", true, List.of(8,9,10,11), 15, 310);
            Product productShoe43 = new Product("NIKE-LV-LOW_W", "Green and black", "Sneaker", true, List.of(9,10,11), 17, 199);
            Product productShoe44 = new Product("NIKE-LV-LOW_X", "Green, black and white", "Sneaker", true, List.of(8,9,10), 15, 240);
            Product productShoe45 = new Product("NIKE-LV-LOW_Y", "White", "Sneaker", true, List.of(7,8,9,10,11), 15, 299);
            Product productShoe46 = new Product("NIKE-LV-LOW_Z", "White and pink", "Sneaker", true, List.of(8,9,10,11), 15, 170);
            //PRODUCTOS//

            //ORDENES//
            Ordered_product ordered_product1= new Ordered_product(1,1,productShoe1);
            //ORDENES//

            //BILLS//
            Bill bill1 = new Bill( LocalDateTime.now(), true, 992.23);
            //BILLS//

            Avatar avatar1 = new Avatar(1,2,1,5,3);
            //CLIENTES//
            Client client1 = new Client("renzo", "balbo", "renzobalbo@skywalkies.com.ar", passwordEncoder.encode("skywalkies"), true, bill1, avatar1);
            //CLIENTES//

            Client_order order1 = new Client_order(ordered_product1);


            clientRepository.save(client1);
            avatarRepository.save(avatar1);
            billRepository.save(bill1);
            ordered_productRepository.save(ordered_product1);
            order1.addOrderedProducts(ordered_product1);



            productRepository.save(productShoe1);
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




            bill1.addClient_order(order1);
            client_orderRepository.save(order1);



        };
    }
    @Autowired
    public PasswordEncoder passwordEncoder;
}

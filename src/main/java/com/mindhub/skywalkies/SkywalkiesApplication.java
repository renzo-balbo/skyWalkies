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


@SpringBootApplication
public class SkywalkiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkywalkiesApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(ClientRepository clientRepository, AvatarRepository avatarRepository, BillRepository billRepository, ProductRepository productRepository, Ordered_ProductRepository ordered_productRepository, Client_OrderRepository client_orderRepository) {
        return (args) -> {







            //PRODUCTOS//
            Product product1 = new Product("MIKExBALVOUITTON Air Adrix", "Red", "Sneaker", true, 43, 12);
            //PRODUCTOS//

            //ORDENES//
            Ordered_product ordered_product1= new Ordered_product(1,1,product1);
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



            productRepository.save(product1);




            bill1.addClient_order(order1);
            client_orderRepository.save(order1);



        };
    }
    @Autowired
    public PasswordEncoder passwordEncoder;
}

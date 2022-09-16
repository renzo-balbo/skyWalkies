package com.mindhub.skywalkies;

import com.mindhub.skywalkies.models.*;


import com.mindhub.skywalkies.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


@SpringBootApplication
public class SkywalkiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkywalkiesApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(ClientRepository clientRepository, AvatarRepository avatarRepository, BillRepository billRepository, ProductRepository productRepository, Ordered_ProductRepository ordered_productRepository, Client_OrderRepository client_orderRepository) {
        return (args) -> {
            Bill bill1 = new Bill( LocalDateTime.now(), true, 992.23 );
            Client client1 = new Client("renzo", "balbo", "renzobalbo@skywalkies.com.ar","skywalkies", true, bill1);
            Avatar avatar1 = new Avatar(1,1,1,1,1);

            Product product1 = new Product("MIKExBALVOUITTON Air Adrix", "Red", "Sneaker", true, 43, 12);
            Ordered_product ordered_product1= new Ordered_product(1,1,product1);
            Client_order order1 = new Client_order(ordered_product1);



            clientRepository.save(client1);
            avatarRepository.save(avatar1);
            billRepository.save(bill1);
            productRepository.save(product1);
            ordered_productRepository.save(ordered_product1);
            client_orderRepository.save(order1);



        };
    }
}

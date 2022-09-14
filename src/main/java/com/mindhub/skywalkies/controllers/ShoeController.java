package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.ShoeAddDTO;
import com.mindhub.skywalkies.dtos.ShoeDTO;
import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Shoe;
import com.mindhub.skywalkies.services.ClientService;
import com.mindhub.skywalkies.services.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ShoeController {
  @Autowired
  private ShoeService shoeService;
  @Autowired
  private ClientService clientService;
  @GetMapping("/shoes")
  public List<ShoeDTO> getShoes() {
    return shoeService.allShoes().stream().map(ShoeDTO::new).collect(Collectors.toList());
  }
  @PostMapping("/addShoe")
  public ResponseEntity<Object> addShoe(@RequestBody ShoeAddDTO shoeAddDTO){
//    Client client = clientService.findClientByEmail(authentication.getName());, Authentication authentication
    List<Shoe> shoes = shoeService.allShoes();
    Shoe shoeName = shoeService.findByName(shoeAddDTO.getName());
//    if (!client.getEmail().contains("@skywalkies")){
//      return new ResponseEntity<>("You not allowed to add a shoe", HttpStatus.METHOD_NOT_ALLOWED);
//    }
    if (shoeAddDTO.getName().isEmpty() || shoeAddDTO.getPrice() < 0 || shoeAddDTO.getSizes().isEmpty() || shoeAddDTO.getStock() < 0){
      return new ResponseEntity<>("Please complete all the fields", HttpStatus.FORBIDDEN);
    }
    if (shoes.stream().filter(shoe -> shoe.getName().equals(shoeName.getName())).count() > 0){
      return new ResponseEntity<>("That Shoe already added", HttpStatus.FORBIDDEN);
    }
    else{
      Shoe shoeAdd = new Shoe(shoeAddDTO.getName(), shoeAddDTO.getColors(), shoeAddDTO.getStock(), shoeAddDTO.getPrice(), shoeAddDTO.getSizes());
      shoeService.saveShoe(shoeAdd);
      return new ResponseEntity<>("Shoe added", HttpStatus.ACCEPTED);
    }
  }
}

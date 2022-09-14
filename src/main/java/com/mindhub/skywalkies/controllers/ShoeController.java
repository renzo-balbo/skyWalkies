package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.ShoeDTO;
import com.mindhub.skywalkies.services.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ShoeController {
  @Autowired
  private ShoeService shoeService;
  @GetMapping("/shoes")
  public List<ShoeDTO> getShoes() {
    return shoeService.allShoes().stream().map(ShoeDTO::new).collect(Collectors.toList());
  }

}

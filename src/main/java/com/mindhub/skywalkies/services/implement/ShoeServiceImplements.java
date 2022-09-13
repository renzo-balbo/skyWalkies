package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Shoe;
import com.mindhub.skywalkies.repositories.ShoeRepository;
import com.mindhub.skywalkies.services.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoeServiceImplements implements ShoeService {
  @Autowired
  private ShoeRepository shoeRepository;
  @Override
  public List<Shoe> allShoes(){return shoeRepository.findAll();}
  @Override
  public Shoe findByName(String name){return shoeRepository.findByName(name);}
  @Override
  public void saveShoe(Shoe shoe) {
    shoeRepository.save(shoe);
  }
}

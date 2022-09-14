package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.Shoe;
import java.util.List;

public interface ShoeService {
  public List<Shoe> allShoes();
  public Shoe findByName(String name);
  public void saveShoe(Shoe shoe);
}

package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.models.Shoe;
import com.mindhub.skywalkies.repositories.ShoeRepository;
import com.mindhub.skywalkies.repositories.UserRespository;
import com.mindhub.skywalkies.services.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Service
    public static class ClientServices implements com.mindhub.skywalkies.services.implement.ClientServices {
        @Autowired
        UserRespository userRespository;

        @Override
        public List<Client> getAllUsers() {
            return userRespository.findAll();
        }

        @Override
        public Client getUserById(long id) {
            return userRespository.findById(id).get();
        }

        @Override
        public Client findUserByemail(String email) {return userRespository.findByEmail(email);

        }
        public void  saveUser(Client user){userRespository.save(user);}
    }
}

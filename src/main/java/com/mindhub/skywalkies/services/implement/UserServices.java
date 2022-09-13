package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.User;
import com.mindhub.skywalkies.repositories.UserRespository;
import com.mindhub.skywalkies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserService {
    @Autowired
    UserRespository userRespository;

    @Override
    public List<User> getAllUsers() {
        return userRespository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRespository.findById(id).get();
    }

    @Override
    public User findUserByemail(String email) {return userRespository.findByEmail(email);

    }

    public void  saveUser(User user){userRespository.save(user);}
}
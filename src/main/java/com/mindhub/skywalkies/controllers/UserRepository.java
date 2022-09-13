package com.mindhub.skywalkies.controllers;

import com.mindhub.skywalkies.dtos.UserDTO;
import com.mindhub.skywalkies.models.User;
import com.mindhub.skywalkies.repositories.UserRespository;
import com.mindhub.skywalkies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserRepository {
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers().stream().map(UserDTO::new).collect(Collectors.toList());
    }

}

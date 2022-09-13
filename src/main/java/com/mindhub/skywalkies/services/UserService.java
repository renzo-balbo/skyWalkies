package com.mindhub.skywalkies.services;

import com.mindhub.skywalkies.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllusers();

    List<User> getAllUsers();

    User getUserById(long id);

    User findUserByemail(String email);
}

package com.example.dockerpractice.practice1.service;

import com.example.dockerpractice.practice1.domain.User;
import com.example.dockerpractice.practice1.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException;

    List<User> getAllUser();
}

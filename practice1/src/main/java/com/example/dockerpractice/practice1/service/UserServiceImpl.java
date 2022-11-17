package com.example.dockerpractice.practice1.service;

import com.example.dockerpractice.practice1.domain.User;
import com.example.dockerpractice.practice1.exception.UserNotFoundException;
import com.example.dockerpractice.practice1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}

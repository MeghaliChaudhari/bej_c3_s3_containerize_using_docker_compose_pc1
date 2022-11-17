package com.example.dockerpractice.practice1.controller;


import com.example.dockerpractice.practice1.domain.User;
import com.example.dockerpractice.practice1.exception.UserNotFoundException;
import com.example.dockerpractice.practice1.service.SecurityTokenGenerator;
import com.example.dockerpractice.practice1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    private UserServiceImpl userServiceImpl;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, SecurityTokenGenerator securityTokenGenerator) {
        this.userServiceImpl = userServiceImpl;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        Map<String,String> map = null;
        try {
            User user1 = userServiceImpl.findByUsernameAndPassword(user.getUsername(),user.getPassword());
            if (user1.getUsername().equals(user.getUsername())){
                map = securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity<>(map,HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (Exception se) {
            responseEntity = new ResponseEntity<>("Try After sometimes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/userdata/v1/fetch")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>(userServiceImpl.getAllUser(),HttpStatus.OK);
    }

}

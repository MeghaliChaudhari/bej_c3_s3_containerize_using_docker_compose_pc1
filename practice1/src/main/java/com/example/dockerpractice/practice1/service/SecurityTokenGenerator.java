package com.example.dockerpractice.practice1.service;

import com.example.dockerpractice.practice1.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}

package com.example.dockerpractice.practice1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found")
public class UserNotFoundException extends Exception{
}

package com.diploma.userservice.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String name){
        super(name);
    }
}

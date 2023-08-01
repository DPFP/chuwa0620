package com.chuwa.learning.rewardcalculatorv2.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super("User with id: "+message+" not found.");
    }
}


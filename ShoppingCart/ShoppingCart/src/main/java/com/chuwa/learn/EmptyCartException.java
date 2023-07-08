package com.chuwa.learn;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message){
        super(message);
    }
}

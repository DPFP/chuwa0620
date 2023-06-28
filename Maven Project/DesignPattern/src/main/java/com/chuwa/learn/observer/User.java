package com.chuwa.learn.observer;

public class User implements Observer{
    private String userName;
    public User(String name){
        this.userName = name;
    }
    @Override
    public void update(String msg) {
        System.out.println(userName + " received: " + msg);
    }
}

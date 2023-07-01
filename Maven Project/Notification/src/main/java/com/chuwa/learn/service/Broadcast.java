package com.chuwa.learn.service;

import com.chuwa.learn.model.User;

import java.util.ArrayList;

public class Broadcast implements Notification{
    private static ArrayList<User> userList = new ArrayList<>();
    @Override
    public void register(User user) {
        userList.add(user);
    }
    @Override
    public void notify(String msg) {
        for(User user: userList){
            System.out.println("Hey " + user.getFirstName() + ", here is a broadcast notification: " + msg);
        }
    }
}

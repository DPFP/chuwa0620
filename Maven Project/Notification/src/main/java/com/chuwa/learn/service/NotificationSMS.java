package com.chuwa.learn.service;

import com.chuwa.learn.model.User;

public class NotificationSMS implements Notification{
    private User user;

    @Override
    public void register(User user) {
        this.user = user;
        String msg = "Hey " + user.getFirstName() + ", you have successfully registered to add and here is your , please use this for future references";
        notify(msg);
    }

    @Override
    public void notify(String msg) {
        System.out.println("Hey " + user.getFirstName() + ", here is your SMS notification: " + msg);
    }
}

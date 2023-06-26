package com.chuwa.learn.impl;

import com.chuwa.learn.intf.Notification;
import com.chuwa.learn.model.UserDetail;

import java.util.HashMap;
import java.util.Map;

public class SmsNotification implements Notification {
    private Map<String,UserDetail> allUsers = new HashMap<>();

    @Override
    public void notifyUser(String msg, UserDetail userDetail) {
        System.out.printf("Sending Sms notification to %s!\n",userDetail.getSms());
        System.out.println(msg);
    }

    @Override
    public void registerUser(UserDetail userDetail) {
        if(this.allUsers == null)allUsers = new HashMap<>();
        allUsers.put(userDetail.getEmail(),userDetail);
        String successMsg = "Hey "+userDetail.getFirstName()+ " you have successfully registered to add and here is your , please use this for \n" +
                "future references.";
        notifyUser(successMsg,userDetail);
    }

    @Override
    public void broadcast(String msg) {
        System.out.printf("Broadcasting\n");
        for(UserDetail usr:allUsers.values()){
            notifyUser(msg,usr);
        }
    }
}

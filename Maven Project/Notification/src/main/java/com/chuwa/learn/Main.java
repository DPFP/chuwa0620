package com.chuwa.learn;

import com.chuwa.learn.model.NotifPreference;
import com.chuwa.learn.model.User;
import com.chuwa.learn.service.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // add test users
        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User("Tom", "Paul", "aa@aa.com", "12345", "123", NotifPreference.EMAIL);
        User user2 = new User("John", "Wick", "bb@aa.com", "67890", "456", NotifPreference.SMS);
        User user3 = new User("Da", "Bal", "cc@aa.com", "34567", "789", NotifPreference.WHATSAPP);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // create notifications
        String msg = "Hello World!";
        Notification broadcast = new Broadcast();
        for(User user: userList){
            Notification notification;
            if(user.getPreference() == NotifPreference.EMAIL){
                notification = new NotificationEmail();
            } else if (user.getPreference() == NotifPreference.SMS) {
                notification = new NotificationSMS();
            } else if (user.getPreference() == NotifPreference.WHATSAPP) {
                notification = new NotificationWhatsApp();
            } else continue;
            notification.register(user);
            broadcast.register(user);
            notification.notify(msg);
        }

        // test broadcast
        broadcast.notify("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
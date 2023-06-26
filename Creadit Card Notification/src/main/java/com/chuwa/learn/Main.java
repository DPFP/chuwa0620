package com.chuwa.learn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("John","john@gmail.com","1111111111", User.preference.EMAIL);
        User user2 = new User("Jimmy","himmy@gmail.com","2222222222", User.preference.SMS);
        User user3 = new User("Neil","neil@gmail.com","3333333333", User.preference.WHATSAPP);
        User user4 = new User("Luna","luna@gmail.com","44444444444", User.preference.EMAIL);
        User user5 = new User("Peter","peter@gmail.com","5555555555", User.preference.SMS);
        User user6 = new User("Mark","mark@gmail.com","6666666666", User.preference.WHATSAPP);
        User user7 = new User("Ben",null,"7777777777", User.preference.EMAIL);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        NotificationDispatcher notificationDispatcher = new NotificationDispatcher(userList);
        System.out.println("\n"+ "Single User Test");
        notificationDispatcher.sendSingleNotification(user1, "40% off when you buy Popeyes between 06/13 - 06/19");
        notificationDispatcher.sendSingleNotification(user2, "40% off when you buy Popeyes between 06/13 - 06/19");
        notificationDispatcher.sendSingleNotification(user3, "40% off when you buy Popeyes between 06/13 - 06/19");
        System.out.println("\n"+ "Broadcast Test");
        notificationDispatcher.sendALLNotification("40% off when you buy Popeyes between 06/13 - 06/19");
        System.out.println("\n"+ "Error Test");
        notificationDispatcher.sendSingleNotification(user7, "40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
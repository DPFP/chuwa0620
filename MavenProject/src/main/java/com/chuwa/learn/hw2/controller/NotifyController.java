package com.chuwa.learn.hw2.controller;

import com.chuwa.learn.hw2.enums.NotificationMsg;
import com.chuwa.learn.hw2.enums.NotificationType;
import com.chuwa.learn.hw2.enums.NotificationWay;
import com.chuwa.learn.hw2.model.User;
import com.chuwa.learn.hw2.service.NotificationService;
import com.chuwa.learn.hw2.service.impl.NotificationServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class NotifyController {

    private static NotificationService notificationService;

    public static void main(String[] args) {
        notificationService = new NotificationServiceImpl();

        User user1 = new User("Bob", "Lin");
        User user2 = new User("Bo", "Lin", NotificationType.SMS);
        User user3 = new User("B", "Lin", NotificationType.SMS);
        User user4 = new User("Bin", "Li", NotificationType.WhatsAPP);
        notificationService.addUser(user1);
        notificationService.addUser(user2);
        notificationService.addUser(user3);
        notificationService.addUser(user4);
        System.out.println();

        // send a broadcast notification
        notificationService.notify(NotificationWay.Broadcast, null, NotificationMsg.BroadcastMsg);

        // send a private msg to user1 and user2
        notificationService.notify(NotificationWay.Private, Arrays.asList(user1, user2), NotificationMsg.RegisterMsg);
    }
}

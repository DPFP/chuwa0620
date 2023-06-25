package com.chuwa.learn.hw2.service.impl;

import com.chuwa.learn.hw2.enums.NotificationMsg;
import com.chuwa.learn.hw2.enums.NotificationWay;
import com.chuwa.learn.hw2.model.User;
import com.chuwa.learn.hw2.service.NotificationService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NotificationServiceImpl implements NotificationService {

    private Set<User> userList;

    public NotificationServiceImpl() {
        userList = new HashSet<>();
    }

    @Override
    public boolean addUser(User user) {
        if (userList.add(user)) {
            System.out.println("successfully add user: " + user);
            return true;
        }
        System.out.println("add user fail");
        return false;
    }

    @Override
    public void notify(NotificationWay notificationWay, List<User> notifyList,
                       NotificationMsg notificationMsg) {

        List<User> finalList = new ArrayList<>(userList);
        if (notificationWay.equals(NotificationWay.Private)) {
            // only notify notify list
            finalList.stream().filter(notifyList::contains).collect(Collectors.toList());
        }

        if (notificationMsg.equals(NotificationMsg.RegisterMsg)) {
            for (User user: finalList) {
                System.out.println("user with id: " + user.getUserId() + " receive: "
                        + String.format(NotificationMsg.RegisterMsg.getMsg(), user.getFirstName()));
            }
        } else if (notificationMsg.equals(NotificationMsg.BroadcastMsg)) {
            for (User user: userList) {
                System.out.println("user with id: " + user.getUserId()
                        + " receive: " + NotificationMsg.BroadcastMsg.getMsg());
            }
        }
        System.out.println();
        System.out.println("finish Notification");
        System.out.println("--------------");
        System.out.println();
    }
}

package com.chuwa.learn.hw2.service;

import com.chuwa.learn.hw2.enums.NotificationMsg;
import com.chuwa.learn.hw2.enums.NotificationWay;
import com.chuwa.learn.hw2.model.User;

import java.util.List;

public interface NotificationService {

    boolean addUser(User user);

    void notify(NotificationWay notificationWay, List<User> notifyList,
                NotificationMsg notificationMsg);
}

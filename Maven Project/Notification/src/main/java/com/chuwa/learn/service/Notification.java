package com.chuwa.learn.service;

import com.chuwa.learn.model.User;

public interface Notification {
    void register(User user);
    void notify(String msg);
}

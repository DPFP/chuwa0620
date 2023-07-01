package com.chuwa.learn.intf;

import com.chuwa.learn.model.UserDetail;

public interface Notification {
    void notifyUser(String msg, UserDetail userDetail);
    void registerUser(UserDetail userDetail);

    void broadcast(String msg);
}

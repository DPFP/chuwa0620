package com.chuwa.learn;

public interface Notification {
    void sendNotification(User user, String message);
    void broadcastNotification(String message);
    void subscribe(User user);
}

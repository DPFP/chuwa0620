package com.chuwa.learn;

import java.util.ArrayList;
import java.util.List;

public class EmailNotification implements Notification {
    private List<User> subscribers;

    public EmailNotification() {
        this.subscribers = new ArrayList<>();
    }

    public void sendNotification(User user, String message) {
        // Implementation to send an email notification
        if (!user.getPreference().equals("email")) {
            throw new IllegalArgumentException("Invalid notification preference: " + user.getPreference());
        }
        System.out.println("Hey " + user.getFirstName() +  ", " + message);
    }

    public void broadcastNotification(String message) {
        for (User user : subscribers) {
            sendNotification(user, message);
        }
    }

    public void subscribe(User user) {
        if (!user.getPreference().equals("email")) {
            System.out.println(user.getFirstName() + " prefer another way of receiving notification");
            return;
        }
        subscribers.add(user);
        System.out.println(user.getEmail() + " subscribed to email notifications.");
    }
}
package com.chuwa.learn;

import java.util.ArrayList;
import java.util.List;

public class WhatsAppNotification implements Notification {
    private List<User> subscribers;

    public WhatsAppNotification() {
        this.subscribers = new ArrayList<>();
    }

    public void sendNotification(User user, String message) {
        // Implementation to send a WhatsApp notification
        if (!user.getPreference().equals("whatsapp")) {
            throw new IllegalArgumentException("Invalid notification preference: " + user.getPreference());
        }
        System.out.println("Hey " + user.getFirstName() +  ", " + message);
    }

    public void broadcastNotification(String message) {
        // Implementation to broadcast a WhatsApp notification to all users
        for (User user : subscribers) {
            sendNotification(user, message);
        }
    }

    public void subscribe(User user) {
        if (!user.getPreference().equals("whatsapp")) {
            System.out.println(user.getFirstName() + " prefer another way of receiving notification");
            return;
        }
        subscribers.add(user);
        System.out.println(user.getEmail() + " subscribed to whatsapp notifications.");
    }
}
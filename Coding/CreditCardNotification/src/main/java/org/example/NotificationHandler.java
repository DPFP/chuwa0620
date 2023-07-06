package org.example;

import java.util.List;

public class NotificationHandler {
    private NotificationService notificationService;

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(User user, String message) {
        try {
            notificationService.sendNotification(user, message);
        } catch (Exception e) {
            // Handle error appropriately when preference doesn't match
            System.out.println("Error occurred while sending notification: " + e.getMessage());
        }
    }

    public void broadcastNotification(List<User> users, String message) {
        for (User user : users) {
            sendNotification(user, message);
        }
    }
}

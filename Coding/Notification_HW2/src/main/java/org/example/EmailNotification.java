package org.example;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(User user, String content) {
        System.out.println("Email sent to " + user.getEmail() + ": " + content);
    }
}

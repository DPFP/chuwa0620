package org.example;

public class EmailNotification implements DoNotification{
    @Override
    public void sentNotification(User user, String message) {
        System.out.println("Sent notification below through email:");
        System.out.println(message);
    }
}

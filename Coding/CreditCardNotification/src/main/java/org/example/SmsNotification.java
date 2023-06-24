package org.example;

public class SmsNotification implements DoNotification{
    @Override
    public void sentNotification(User user, String message) {
        System.out.println("Sent notification below through SMS:");
        System.out.println(message);
    }
}

package org.example;

public class WhatsAppNotification implements DoNotification{
    @Override
    public void sentNotification(User user, String message) {
        System.out.println("Sent notification below through WhatsAPP:");
        System.out.println(message);
    }
}

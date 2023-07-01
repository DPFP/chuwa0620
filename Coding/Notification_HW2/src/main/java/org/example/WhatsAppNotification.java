package org.example;

public class WhatsAppNotification implements Notification{

    @Override
    public void sendNotification(User user, String content) {
        System.out.println("WhatsApp message sent to " + user.getPhoneNumber() + ": " + content);
    }
}

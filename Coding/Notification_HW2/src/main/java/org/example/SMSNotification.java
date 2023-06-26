package org.example;

public class SMSNotification implements Notification{

    @Override
    public void sendNotification(User user, String content) {
        System.out.println("SMS sent to " + user.getPhoneNumber() + ": " + content);
    }
}

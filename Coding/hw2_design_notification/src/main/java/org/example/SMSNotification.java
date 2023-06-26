package org.example;

public class SMSNotification implements Notification{

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("This message is sent to " + user.getFirstName() + " user via SMS.");
        System.out.println("The message is: " + message);
    }
}

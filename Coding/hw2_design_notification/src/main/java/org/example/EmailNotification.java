package org.example;

public class EmailNotification implements Notification{
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("This message is sent to " + user.getFirstName() + " user via Email.");
        System.out.println("The message is: " + message);
    }
}

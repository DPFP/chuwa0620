package com.chuwa.learn;

import java.util.ArrayList;
import java.util.List;

enum NotificationType {
    EMAIL, SMS, WHATSAPP, INVALID
}

// Define Notification interface
interface Notification {
    void sendNotification(String recipient, String message);
}

class EmailNotification implements Notification {
    @Override
    public void sendNotification(String recipient, String message) {
        // Implement email notification logic here
        System.out.println("Sending email notification to " + recipient + ": " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void sendNotification(String recipient, String message) {
        // Implement SMS notification logic here
        System.out.println("Sending SMS notification to " + recipient + ": " + message);
    }
}

class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String recipient, String message) {
        // Implement WhatsApp notification logic here
        System.out.println("Sending WhatsApp notification to " + recipient + ": " + message);
    }
}

class NotificationService {
    private List<User> users;

    public NotificationService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void sendNotification(User user, String message) {
        NotificationType preference = user.getPreference();
        Notification notification = switch (preference) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            case WHATSAPP -> new WhatsAppNotification();
            default -> throw new IllegalArgumentException("Invalid notification type: " + user.getFirstName());
        };

        notification.sendNotification(user.getFirstName(), message);

    }

    public void broadcastToUser(String message) {
        for (User user : users) {
            String tmp = "";
            switch(user.getPreference()){
                case SMS, WHATSAPP: {tmp = user.getPhone(); break;}
                case EMAIL: {tmp = user.getEmail(); break;}
                default:
            }
            sendNotification(user, String.format(message, user.getFirstName(), tmp));
        }
    }
    public void broadcastPublic(String message) {
        for (User user : users) {
            sendNotification(user, message);
        }
    }
}

class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private NotificationType notificationPreference;

    // Constructor and getters/setters

    public User(String firstName, String lastName, String email, String phoneNumber, NotificationType notificationPreference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notificationPreference = notificationPreference;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getPhone(){
        return this.phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public NotificationType getPreference(){
        return this.notificationPreference;
    }

    public String getPreferenceString(){
        switch(this.notificationPreference){
            case SMS : return "SMS";
            case EMAIL : return "EMAIL";
            case WHATSAPP : return "WHATSAPP";
            default : return "INVALID";
        }

    }

}

// Example usage
public class CreditCardNotificationSystem {
    public static void main(String[] args) {
        User userA = new User("John", "Doe", "john.doe@example.com", "1234567890", NotificationType.EMAIL);
        User userB = new User("Jane", "Smith", "", "9876543210", NotificationType.SMS);
        User userC = new User("Sam", "Lark", "", "1231231233", NotificationType.INVALID); // Invalid notification type

        NotificationService service = new NotificationService();
        service.addUser(userA);
        service.addUser(userB);
        service.addUser(userC);

        try{
            service.broadcastToUser("Hey %s, you have successfully registered, your id is %s, please use this for future references");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            service.broadcastPublic("40% off when you buy Popeyes between 06/13 - 06/19");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

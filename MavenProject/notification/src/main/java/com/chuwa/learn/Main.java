package com.chuwa.learn;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User("John", "john@example.com", "+123456789", "whatsapp:123456789", "email");
        User user2 = new User("Abby", "abby@example.com", "+987654321", "whatsapp:987654321", "sms");
        User user3 = new User("Paul", "paul@example.com", "+444444444", "whatsapp:444444444", "whatsapp");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        EmailNotification emailNotification = new EmailNotification();
        SMSNotification smsNotification = new SMSNotification();
        WhatsAppNotification whatsAppNotification = new WhatsAppNotification();


        for (User user : userList) {
            emailNotification.subscribe(user);
            smsNotification.subscribe(user);
            whatsAppNotification.subscribe(user);
        }

        try {
            // try notification
            String firstNotificationPart = "you have successfully registered to add and here is your ";
            String secondNotificationPart = "please use this for future references";

            // success
            emailNotification.sendNotification(user1, firstNotificationPart + user1.getEmail() + secondNotificationPart);

            // error
            emailNotification.sendNotification(user2, firstNotificationPart + user2.getEmail() + secondNotificationPart);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // try broadcast
        String broadcast = "40% off when you buy Popeyes between 06/13 - 06/19";
        emailNotification.broadcastNotification(broadcast);
        smsNotification.broadcastNotification(broadcast);
        whatsAppNotification.broadcastNotification(broadcast);
    }
}

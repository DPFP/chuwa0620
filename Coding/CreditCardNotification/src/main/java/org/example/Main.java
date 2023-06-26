package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create the notification handler
        NotificationHandler notificationHandler = new NotificationHandler();

        // Create the appropriate notification service based on the preference
        NotificationService notificationService;
        String preference = "EMAIL"; // Replace with the user's preference

        if (preference.equalsIgnoreCase("EMAIL")) {
            notificationService = new EmailNotificationService();
        } else if (preference.equalsIgnoreCase("SMS")) {
            notificationService = new SMSNotificationService();
        } else if(preference.equalsIgnoreCase("WHATSAPP")) {
            // Handle the case when preference is not matched
            notificationService = new WHATSAPPNotificationService();
        } else {
            // Handle the case when preference is not matched
            System.out.println("Preference not matched.");
            return;
        }

        // Set the notification service in the handler
        notificationHandler.setNotificationService(notificationService);

        // Prepare the notification content
        List<User> users = new ArrayList<>(){{
            add(User.builder().firstName("John").lastName("Doe").email("John@example.com").build());
            add(User.builder().firstName("Jane").lastName("Doe").email("Jane@example.com").build());
        }};

        String broadcastMessage = "40% off when you buy Popeyes between 06/13 - 06/19";

        // Send the notification
        notificationHandler.sendNotification(users.get(0), "");
        notificationHandler.broadcastNotification(users, broadcastMessage);

    }
}

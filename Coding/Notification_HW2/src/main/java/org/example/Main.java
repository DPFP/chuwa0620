package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating users
        User alice = new User(
                "Alice",
                "alice@example.com",
                "1234567890",
                new EmailNotification()
        );


        User bob = new User(
                "Bob",
                "bob@example.com",
                "0987654321",
                new SMSNotification());

        // Creating a list of users
        List<User> users = new ArrayList<>();
        users.add(alice);
        users.add(bob);

        // Creating a Notifier
        Notifier notifier = new Notifier(users);

        // Sending registration notifications
        notifier.sendRegistrationNotification(alice);
        notifier.sendRegistrationNotification(bob);

        // Sending a public notification
        notifier.broadcastPublicNotification();
    }
}
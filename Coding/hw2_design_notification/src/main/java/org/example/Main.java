package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User love = new User("love", "love007@gmail.com", "8797890023",
                "ioddlja", "Email");
        User stephen = new User("stephen", "ooistepen9@hotmail.com", "9992008989",
                "stephen666999", "SMS");
        List<User> Users = new ArrayList<>();
        Users.add(love);
        Users.add(stephen);

        MessageSender sender = new MessageSender(Users);
        sender.broadcastRegistration();
        System.out.println();
        String broadcastMessage = "40% off when you buy Popeyes between 06/13 - 06/19";
        sender.broadcast(broadcastMessage);
        System.out.println();
        String messageToOneUser = "You are eligible for a free credit raise";
        sender.sendOneMessage(love, messageToOneUser);
    }
}
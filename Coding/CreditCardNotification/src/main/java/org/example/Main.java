package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User("001", "John", "Wei", "234234", NotificationMethods.EMAIL, "john@gmail.com", "2343654987", "3425678543");
        User user2 = new User("002", "House", "Liu", "098098", NotificationMethods.SMS, "h12@gmail.com", "2343654987", "3425678543");
        User user3 = new User("003", "Brain", "Zhang", "456456", NotificationMethods.WHATSAPP, "bbaa@gmail.com", "2343654987", "3425678543");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        NotificationManager notificationManager = new NotificationManager(userList);
        notificationManager.sendNotificationToSingleUser("001");
        notificationManager.sendNotificationToSingleUser("002");
        notificationManager.broadcastToAll();
    }
}
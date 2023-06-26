package org.example;

import java.util.List;

public class Notifier {
    private List<User> users;

    public Notifier(List<User> users) {
        this.users = users;
    }

    public void notifyUser(User user, String content) {
        //user.getPreference() 返回一个 Notification 类型的对象，
        // 这是由 User 类中的 getPreference() 方法决定的。
        // 这个 Notification 对象是一个接口，它有一个 sendNotification() 方法。
        try {
            user.getPreference().sendNotification(user, content);
        } catch (Exception e) {
            System.out.println("Error sending notification to " + user.getFirstName() + ": " + e.getMessage());
        }
    }
    public void sendRegistrationNotification(User user) {
        String content = "Hey " + user.getFirstName() + ", you have successfully registered. Please use this for future references.";
        notifyUser(user, content);
    }

    public void broadcastPublicNotification() {
        String content = "40% off when you buy Popeyes between 06/13 - 06/19";
        for (User user : users) {
            notifyUser(user, content);
        }
    }

}

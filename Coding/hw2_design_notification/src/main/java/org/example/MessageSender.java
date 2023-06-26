package org.example;

import java.util.List;

public class MessageSender {
    private List<User> userList;
    public MessageSender(List<User> userList) {
        this.userList = userList;
    }

    public void sendOneMessage(User user, String message) {
        try {
            user.getPreference().sendNotification(user, message);
        } catch (Exception e) {
            System.out.println("Error when sending notificaton to" + user.getFirstName() + "via" +
                    user.getPreferenceString());
        }
    }

    private void registationMessage(User user) {
        String message = "Hey  " + user.getFirstName() + " you have successfully registered to the notification system" +
                " add and here is your " + user.getPreferenceString() + ", please use this for future references.";
        sendOneMessage(user, message);
    }
    public void broadcast(String message) {
        for (User user : userList) {
            sendOneMessage(user, message);
        }
    }

    public void broadcastRegistration() {
        for (User user : userList) {
            registationMessage(user);
        }
    }
}

package Notification;

import pojo.User;

import java.util.ArrayList;
import java.util.List;

public class Broadcast implements Notification{
    private List<User> userList = new ArrayList<>();

    public Broadcast(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void sendNotification(String notificationContent) {
        for (User user : userList) {
            user.sendNotification(notificationContent);
            System.out.println();
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

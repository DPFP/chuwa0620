package Notification;

import pojo.User;

public class EmailNotification implements Notification{
    private String emailAddress;
    private User user;

    public EmailNotification(String emailAddress, User user) {
        this.emailAddress = emailAddress;
        this.user = user;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void sendNotification(String notificationContent) {
        System.out.println("sending email notification to " + emailAddress);
        System.out.println("Hey " + user.getFirstName() + ", "+notificationContent);
    }
}

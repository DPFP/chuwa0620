package Notification;

import pojo.User;

public class SmsNotification implements Notification{
    private String smsNumber;
    private User user;

    public SmsNotification(String smsNumber, User user) {
        this.smsNumber = smsNumber;
        this.user = user;
    }

    @Override
    public void sendNotification(String notificationContent) {
        System.out.println("sending sms notification to " + smsNumber);
        System.out.println("Hey " + user.getFirstName() + ", "+notificationContent);
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
    }
}

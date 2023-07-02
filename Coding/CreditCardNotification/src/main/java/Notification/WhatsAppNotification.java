package Notification;

import pojo.User;

public class WhatsAppNotification implements Notification{
    private String whatsappNumber;
    private User user;

    public WhatsAppNotification(String whatsappNumber, User user) {
        this.whatsappNumber = whatsappNumber;
        this.user = user;
    }

    @Override
    public void sendNotification(String notificationContent) {
        System.out.println("sending whatsapp notification to " + whatsappNumber);
        System.out.println("Hey " + user.getFirstName() + ", "+notificationContent);
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

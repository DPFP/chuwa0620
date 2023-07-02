package pojo;

import Notification.EmailNotification;
import Notification.Notification;
import Notification.SmsNotification;
import Notification.WhatsAppNotification;

public class User {
    private String firstName;
    private String lastName;
    private String preference;

    private String contactNumber;

    public User(String firstName, String lastName, String preference, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.preference = preference;
        this.contactNumber = contactNumber;
    }

    public void sendNotification(String notificationContent) {
        if (this.getPreference() == "email") {
            Notification noti = new EmailNotification(this.getContactNumber(), this);
            noti.sendNotification(notificationContent);
        } else if (this.getPreference() == "sms") {
            Notification noti = new SmsNotification(this.getContactNumber(), this);
            noti.sendNotification(notificationContent);
        } else if (this.getPreference() == "whatsapp") {
            Notification noti = new WhatsAppNotification(this.getContactNumber(), this);
            noti.sendNotification(notificationContent);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}

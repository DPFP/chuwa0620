package org.example;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private NotificationMethods notificationPreference;
    private String email;
    private String smsNumber;
    private String whatsAppNumber;

    public User(String id, String firstName, String lastName, String password, NotificationMethods notificationPreference, String email, String smsNumber, String whatsAppNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.notificationPreference = notificationPreference;
        this.email = email;
        this.smsNumber = smsNumber;
        this.whatsAppNumber = whatsAppNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NotificationMethods getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(NotificationMethods notificationPreference) {
        this.notificationPreference = notificationPreference;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
    }

    public String getWhatsAppNumber() {
        return whatsAppNumber;
    }

    public void setWhatsAppNumber(String whatsAppNumber) {
        this.whatsAppNumber = whatsAppNumber;
    }
}

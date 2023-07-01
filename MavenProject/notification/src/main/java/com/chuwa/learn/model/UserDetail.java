package com.chuwa.learn.model;

public class UserDetail {
    private String firstName;
    private String lastName;
    private NotificationPreference notificationPreference;

    private String email;
    private String sms;
    private String whatsapp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
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

    public NotificationPreference getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(NotificationPreference notificationPreference) {
        this.notificationPreference = notificationPreference;
    }

    public UserDetail(String firstName, String lastName, NotificationPreference notificationPreference, String email, String sms, String whatsapp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.notificationPreference = notificationPreference;
        this.email = email;
        this.sms = sms;
        this.whatsapp = whatsapp;
    }
}

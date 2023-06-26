package com.chuwa.learn;

public class User {
    private String firstName;
    private String email;
    private String phoneNumber;
    private String whatsAppNumber;

    private final String preference;

    public User(String firstName, String email, String phoneNumber, String whatsAppNumber, String preference) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.whatsAppNumber = whatsAppNumber;
        this.preference = preference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWhatsAppNumber() {
        return whatsAppNumber;
    }

    public String getPreference() {
        return preference;
    }
}

package org.example;



public class User {
    private String firstName;
    private String email;
    private String phoneNumber;
    private Notification preference;

    public User(String firstName, String email, String phoneNumber,Notification preference) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preference = preference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Notification getPreference() {
        return preference;
    }

    public void setPreference(Notification preference) {
        this.preference = preference;
    }
}

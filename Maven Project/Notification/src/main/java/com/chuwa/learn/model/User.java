package com.chuwa.learn.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String sms;
    private String whatsApp;
    // default method is email
    private NotifPreference preference = NotifPreference.EMAIL;

    public User(String firstName, String lastName, String email, String sms, String whatsApp, NotifPreference preference){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sms = sms;
        this.whatsApp = whatsApp;
        this.preference = preference;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
    public String getSms(){
        return sms;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }
    public String getWhatsApp(){
        return whatsApp;
    }

    public void setPreference(NotifPreference preference) {
        this.preference = preference;
    }
    public NotifPreference getPreference(){
        return preference;
    }
}

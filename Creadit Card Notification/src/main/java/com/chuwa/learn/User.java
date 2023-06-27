package com.chuwa.learn;

public class User {
    enum preference{
        EMAIL,
        SMS,
        WHATSAPP
    }
    private String firstName;
    private String email;
    private String phoneNumber;
    private preference preference;

    public User(String firstName, String email, String phoneNumber, preference preference){
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preference = preference;
        System.out.println("Hey " + firstName + ",you have successfully registered to add and here is your " + preference + ", please use this for future references.");
    }
    public String getFirstName(){
        return firstName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public preference getPreference(){
        return preference;
    }
}

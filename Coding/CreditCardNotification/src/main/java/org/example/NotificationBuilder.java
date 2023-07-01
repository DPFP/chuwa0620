package org.example;

public class NotificationBuilder {
    public static String generateNotification(String firstName, String method, String contact){

        return String.format("Hey %s, you have successfully registered to add and here is your %s. \n%s\nPlease use this for future references.", firstName, method, contact);
    }
}

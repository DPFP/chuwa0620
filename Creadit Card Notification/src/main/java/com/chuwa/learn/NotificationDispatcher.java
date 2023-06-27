package com.chuwa.learn;

import java.util.List;

public class NotificationDispatcher {
    private List<User> users;
    public NotificationDispatcher(List<User> users){
        this.users = users;
    }

    public void sendSingleNotification(User user, String message){
        Notification notification;
        switch(user.getPreference()){
            case EMAIL -> {
                if(user.getEmail() == null){
                    System.out.println("ERROR: " + user.getFirstName() + "'s preference notification email not given. Sending notification failed");
                }
                else{
                    notification = new EmailNotification();
                    notification.messageNotification(user,message);
                }

            }
            case SMS -> {
                if(user.getPhoneNumber() == null){
                    System.out.println("ERROR: " + user.getFirstName() + "'s preference notification phone number not given. Sending notification failed");
                }
                else{
                    notification = new SMSNotification();
                    notification.messageNotification(user,message);
                }
            }
            case WHATSAPP -> {
                if(user.getPhoneNumber() == null){
                    System.out.println("ERROR: " + user.getFirstName() + "'s preference notification WhatsApp number not given. Sending notification failed");
                }
                else{
                    notification = new WhatsAppNotification();
                    notification.messageNotification(user,message);
                }
            }
        }

    }

    public void sendALLNotification(String message){
        for(User user:users){
            sendSingleNotification(user, message);
        }
    }
}

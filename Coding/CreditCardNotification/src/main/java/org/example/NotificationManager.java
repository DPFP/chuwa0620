package org.example;

import java.util.List;

public class NotificationManager {
    private List<User> userList;


    NotificationManager(List<User> userList){
        this.userList = userList;
    }
    public void sendNotificationToSingleUser(String id){
        for(User user: userList){
            if(id.equals(user.getId())){
                NotificationMethods m = user.getNotificationPreference();
                String method = null;
                String contact = null;
                DoNotification notification;
                if(m == NotificationMethods.EMAIL){
                    method = "email";
                    contact = user.getEmail();
                    notification = new EmailNotification();
                }
                else if(m == NotificationMethods.SMS){
                    method = "phone number";
                    contact = user.getSmsNumber();
                    notification = new SmsNotification();
                }
                else{
                    method = "WhatsApp id";
                    contact = user.getWhatsAppNumber();
                    notification = new WhatsAppNotification();
                }
                notification.sentNotification(user, NotificationBuilder.generateNotification(user.getFirstName(), method, contact));
            }
        }
    }

    public void broadcastToAll(){
        for(User user: this.userList){
            NotificationMethods m = user.getNotificationPreference();
            DoNotification notification;
            if(m == NotificationMethods.EMAIL){
                notification = new EmailNotification();
            }
            else if(m == NotificationMethods.SMS){
                notification = new SmsNotification();
            }
            else{
                notification = new WhatsAppNotification();
            }
            notification.sentNotification(user, "40% off when you buy Popeyes between 06/13 - 06/19");
        }
    }
}

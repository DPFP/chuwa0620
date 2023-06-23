package org.example.notification;

public class SMSNotificationStrategy implements NotificationStrategy {

    @Override
    public void notify(Boolean isGlobal, String userName, String prompt) {
        if (isGlobal){
            System.out.println("To " + userName + " by SMS: " + prompt);
        } else {
            System.out.println("To " + userName + " by SMS: Hey " + userName + ", " + prompt);
        }
    }
}

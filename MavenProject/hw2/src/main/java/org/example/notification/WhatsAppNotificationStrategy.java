package org.example.notification;

public class WhatsAppNotificationStrategy implements NotificationStrategy{
    @Override
    public void notify(Boolean isGlobal, String userName, String prompt) {

        if (isGlobal){
            System.out.println("To " + userName + " by WhatsApp: " + prompt);
        } else {
            System.out.println("To " + userName + " by WhatsApp: Hey " + userName + ", " + prompt);
        }
    }
}

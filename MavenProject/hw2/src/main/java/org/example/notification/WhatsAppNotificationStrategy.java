package org.example.notification;

public class WhatsAppNotificationStrategy implements NotificationStrategy{

    /**
     * @param isGlobal: To see if this message sends to all users without username
     * @param userName: user name
     * @param prompt: some message
     * @return void
     * @description THis function is to notify subscriber by WhatsApp
     * @author zhanghm
     * @date 6/23/23 2:39 PM
     */
    @Override
    public void notify(Boolean isGlobal, String userName, String prompt) {

        if (isGlobal){
            System.out.println("To " + userName + " by WhatsApp: " + prompt);
        } else {
            System.out.println("To " + userName + " by WhatsApp: Hey " + userName + ", " + prompt);
        }
    }
}

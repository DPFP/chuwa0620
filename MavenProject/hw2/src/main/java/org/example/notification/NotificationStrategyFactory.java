package org.example.notification;

import org.example.NotificationPreference;

public class NotificationStrategyFactory {
    /**
     * @description This is a notification strategy factory

     * @param notificationPreference: ENUM type of notification preference
     * @return NotificationStrategy
     * @author zhanghm
     * @date 6/23/23 3:16 PM
     */

    public NotificationStrategy createNotificationStrategy(NotificationPreference notificationPreference){
        if (notificationPreference == NotificationPreference.SMS) {
            return new SMSNotificationStrategy();
        } else if (notificationPreference == NotificationPreference.EMAIL) {
            return new EmailNotificationStrategy();
        } else if (notificationPreference == NotificationPreference.WHATSAPP) {
            return new WhatsAppNotificationStrategy();
        }
        return null;
    }
}

package org.example.notification;

import org.example.NotificationPreference;

public class NotificationStrategyFactory {
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

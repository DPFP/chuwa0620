package factory;

import notification.*;

public class NotificationFactory {
    public NotificationInterface getNotificationService(NotificationType notificationType) throws Exception{
        switch (notificationType) {
            case WHATSAPP:
                return new WhatsappNotification();
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            default:
                throw new Exception("Invalid notification type");
        }
    }
}

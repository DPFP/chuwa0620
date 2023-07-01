package com.chuwa.learn.model;

import com.chuwa.learn.impl.EmailNotification;
import com.chuwa.learn.impl.SmsNotification;
import com.chuwa.learn.impl.WhatsAppNotification;
import com.chuwa.learn.intf.Notification;

public class NotificationFactory {
    public Notification createNotification(NotificationPreference channel)
    {
        if (channel == null)
            return null;
        Notification notification;
        switch (channel) {
            case SMS:
                notification = new SmsNotification();
                return notification;
            case EMAIL:
                notification = new EmailNotification();
                return notification;
            case WHATSAPP:
                notification = new WhatsAppNotification();
                return notification;
            default:
                throw new IllegalArgumentException("Unknown channel "+ channel.toString());
        }
    }
}

package com.chuwa.learn;

import com.chuwa.learn.intf.Notification;
import com.chuwa.learn.model.NotificationFactory;
import com.chuwa.learn.model.NotificationPreference;
import com.chuwa.learn.model.UserDetail;

public class Main {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        UserDetail usr = new UserDetail("Sam","Fisher", NotificationPreference.EMAIL, "email", "sms", "whatsapp");
        Notification smsNotification = notificationFactory.createNotification(NotificationPreference.SMS);
        Notification emailNotification = notificationFactory.createNotification(NotificationPreference.EMAIL);
        Notification whatsAppNotification = notificationFactory.createNotification(NotificationPreference.WHATSAPP);

        emailNotification.registerUser(usr);
        smsNotification.broadcast("40% off when you buy Popeyes between 06/13 - 06/19 \n");
        whatsAppNotification.broadcast("40% off when you buy Popeyes between 06/13 - 06/19 \n");
        emailNotification.broadcast("40% off when you buy Popeyes between 06/13 - 06/19 \n");

    }
}
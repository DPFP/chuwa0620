package org.example.Observer;

import org.example.notification.NotificationStrategy;

public class CreditCardObserver implements Observer {
    private String name;
    private String phone;
    private String email;
    private NotificationStrategy notificationStrategy;

    public CreditCardObserver(String name, String phone, String email, NotificationStrategy notificationStrategy) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.notificationStrategy = notificationStrategy;
    }

    @Override
    public void update(Boolean isGlobal, String prompt) {
        notificationStrategy.notify(isGlobal, this.name, prompt);
    }
}

package org.example.Observer;

import org.example.notification.NotificationStrategy;

public class CreditCardObserver implements Observer {
    private String name;
    private String phone;
    private String email;
    private NotificationStrategy notificationStrategy;

    /**
     * This is the constructor function ,which will init the notification strategy
     *
     * @param name
     * @param phone
     * @param email
     * @param notificationStrategy
     */
    public CreditCardObserver(String name, String phone, String email, NotificationStrategy notificationStrategy) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.notificationStrategy = notificationStrategy;
    }

    /**
     * This function is to receive notification from subject.
     *
     * @param isGlobal
     * @param prompt
     */
    @Override
    public void update(Boolean isGlobal, String prompt) {
        notificationStrategy.notify(isGlobal, this.name, prompt);
    }
}

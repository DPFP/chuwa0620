package org.example.notification;

public interface NotificationStrategy {
    void notify(Boolean isGlobal, String userName, String prompt);
}

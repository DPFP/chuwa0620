package user;

import notification.NotificationType;

public class User {
    private String name;
    private NotificationType notificationPreference;

    public User(String name){
        this.name = name;
        notificationPreference = NotificationType.SMS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NotificationType getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(NotificationType notificationPreference) {
        this.notificationPreference = notificationPreference;
    }
}

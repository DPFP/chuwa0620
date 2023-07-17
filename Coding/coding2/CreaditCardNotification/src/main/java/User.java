public class User {
    private String firstName;
    private String notificationAddress;

    private NotificationPreference notificationPreference;

    public User(String firstName, String notificationAddress, NotificationPreference notificationPreference) {
        this.firstName = firstName;
        this.notificationAddress = notificationAddress;
        this.notificationPreference = notificationPreference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNotificationAddress() {
        return notificationAddress;
    }

    public NotificationPreference getNotificationPreference() {
        return notificationPreference;
    }


}
import java.util.ArrayList;

public class NotificationFactory {

    private static ArrayList<User> users = new ArrayList<User>();

    public static NotificationService createNotificationService(User user) {
        NotificationPreference preference = user.getNotificationPreference();
        switch (preference) {
            case EMAIL:
                return new EmailNotificationService();
            case SMS:
                return new SMSNotificationService();
            case WHATSAPP:
                return new WhatsAppNotificationService();
            default:
                throw new IllegalArgumentException("Invalid notification preference");
        }
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void sendNotification(User user) {
        NotificationService notificationService = NotificationFactory.createNotificationService(user);
        notificationService.sendNotification(user, String.format("Hey %s, you have successfully registered to add %s, and here is your notification address: %s, " +
                        "please use this for future references",
                user.getFirstName(), user.getNotificationPreference().name(), user.getNotificationAddress()));
    }

    public static void sendNotification(String message, User user) {
        NotificationService notificationService = NotificationFactory.createNotificationService(user);
        notificationService.sendNotification(user, message);
    }


    public static void broadcastNotification(String message) {
        for (User user : users) {
            sendNotification(message, user);
        }
    }
}

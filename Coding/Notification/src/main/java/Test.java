import factory.NotificationFactory;
import notification.NotificationInterface;
import notification.NotificationType;
import user.User;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");
        user2.setNotificationPreference(NotificationType.EMAIL);
        User user3 = new User("user3");
        user3.setNotificationPreference(NotificationType.WHATSAPP);

        String msgSingle = "you have successfully registered to add and here is your , please use this for\n" +
                "future references.";
        String msgBroadcast = "40% off when you buy Popeyes between 06/13 - 06/19";

        try {
            // notification factory
            NotificationFactory notificationFactory = new NotificationFactory();
            // user1 service
            NotificationInterface user1NotificationService = notificationFactory.getNotificationService(user1.getNotificationPreference());
            user1NotificationService.notifyUser(user1, msgSingle);
            // user2 service
            NotificationInterface user2NotificationService = notificationFactory.getNotificationService(user2.getNotificationPreference());
            user2NotificationService.notifyUser(user2, msgSingle);
            // user3 service
            NotificationInterface user3NotificationService = notificationFactory.getNotificationService(user3.getNotificationPreference());
            user1NotificationService.notifyUser(user3, msgSingle);

            // send broadcast service
            // suppose send broadcast service using SMS
            NotificationInterface broadServiceSMS = notificationFactory.getNotificationService(NotificationType.SMS);
            broadServiceSMS.registerUser(user1);
            broadServiceSMS.registerUser(user2);
            broadServiceSMS.registerUser(user3);
            broadServiceSMS.broadCast(msgBroadcast);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
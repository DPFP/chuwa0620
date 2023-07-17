public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        // Implementation to send an SMS notification to the user
        System.out.println("Sending SMS notification to " + user.getFirstName() + ": " + message);
    }
}
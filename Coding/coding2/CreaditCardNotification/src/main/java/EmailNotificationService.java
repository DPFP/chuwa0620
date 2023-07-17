public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        // Implementation to send an email notification to the user
        System.out.println("Sending email notification to " + user.getFirstName() + ": " + message);
    }
}
public class WhatsAppNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        // Implementation to send a WhatsApp notification to the user
        System.out.println("Sending WhatsApp notification to " + user.getFirstName() + ": " + message);
    }
}
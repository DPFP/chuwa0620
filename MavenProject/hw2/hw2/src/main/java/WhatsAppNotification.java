public class WhatsAppNotification implements Notification{
    @Override
    public void messageNotification(User user, String message){
        System.out.println("WhatsApp notification sent to " + user.getFirstName() + ": " + message);
    }
}

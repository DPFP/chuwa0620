public class SMSNotification implements Notification{
    @Override
    public void messageNotification(User user, String message){
        System.out.println("SMS notification sent to " + user.getFirstName() + ": " + message);
    }
}

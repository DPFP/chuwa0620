public class EmailNotification implements Notification{
    @Override
    public void messageNotification(User user, String message){
        System.out.println("Email notification sent to " + user.getFirstName() + ": " + message);
    }
}

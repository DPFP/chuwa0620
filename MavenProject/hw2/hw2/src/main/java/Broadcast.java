import java.util.List;

public class Broadcast {
    private List<User> users;
    public Broadcast(List<User> users){
        this.users = users;
    }

    public void sendNotice(User user, String msg){
        Notification notification;
        if(user.getPreference() == User.preference.EMAIL){
            notification = new EmailNotification();
            notification.messageNotification(user,msg);
        } else if (user.getPreference() == User.preference.SMS){
            notification = new SMSNotification();
            notification.messageNotification(user,msg);
        } else if (user.getPreference() == User.preference.WHATSAPP){
            notification = new WhatsAppNotification();
            notification.messageNotification(user,msg);
        }
    }

    public void broadcastALL(String msg){
        for(User user:users){
            sendNotice(user, msg);
        }
    }
}

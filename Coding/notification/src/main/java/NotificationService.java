public class NotificationService {
    SendMsg type;
    public void sendMsgByType(User user){
        if(user.getPreference() == Type.Email){
            type = new EmailNotification();
        }
        else if(user.getPreference() == Type.SMS){
            type = new SMSNotification();
        }
        else if(user.getPreference() == Type.WHATSAPP){
            type = new WhatsAppNotification();
        }


        type.send("Hey "+user.getUserName()+", you have successfully registered to add and here is your , please use this for\n" +
                "future references.");
    }

    public void broadAll(User user, String msg){
        if(user.getPreference() == Type.Email){
            type = new EmailNotification();
        }
        else if(user.getPreference() == Type.SMS){
            type = new SMSNotification();
        }
        else if(user.getPreference() == Type.WHATSAPP){
            type = new WhatsAppNotification();
        }

        type.send(msg);
    }

}

package org.example;

public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        if(message.equals("")){
            message = String.format("Hey %s, you have successfully registered to add and here is your , please use this for\n" +
                    "future references.", user.getFirstName());
        }
        String preMessage = "Sending an SMS notification to " + user.getFirstName() + user.getLastName() + ":\n";
        System.out.println(preMessage + message);
    }
}

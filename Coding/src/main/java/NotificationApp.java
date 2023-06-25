import java.lang.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

class NotificationApp {

    public static void registeredNotification(User user) {
        String template = String.format("Hey %s, you have successfully registered to add and here is your credit card, please use this for future references.",user.getFirstName());
        user.sendNotification(template);
    }

    public static void broadcastNotification(List<User> users, String message) {
        for (User user : users) {
            user.sendNotification(message);
        }
    }

    public static void main(String[] args) {
        User user1 = new User("Bill","123","bill@g.com","wh_bill",NotificationFactory.createNotification("sms"));
        User user2 = new User("Alice","234","alice@g.com","wh_alice",NotificationFactory.createNotification("email"));
        User user3 = new User("Mike","456","mike@g.com","wh_mike",NotificationFactory.createNotification("whatsapp"));
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        for(User user:userList) {
            registeredNotification(user);
        }

        String message = "40% off when you buy Popeyes between 06/13 - 06/19";
        broadcastNotification(userList,message);
    }
}


class User {
    private String firstName;
    private String phoneNumber;
    private String email;
    private String whatsAppId;

    private Notification notification;

    public User(String firstName, String phoneNumber, String email, String whatsAppId, Notification notification) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.whatsAppId = whatsAppId;
        this.notification = notification;
    }

    public String getFirstName() {return firstName;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmail() {return email;}
    public String getWhatsAppId(){return whatsAppId;}

    public void sendNotification(String message) {
        notification.sendNotification(this,message);
    }

}

// Notification Factory
class NotificationFactory {
    public static Notification createNotification(String preference) throws IllegalArgumentException {
        if (preference.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (preference.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        } else if (preference.equalsIgnoreCase("whatsapp")) {
            return new WhatsAppNotification();
        }
        throw new IllegalArgumentException("Invalid notification preference: " + preference);
    }
}

interface Notification {
    void sendNotification(User user, String message);
}

class EmailNotification implements Notification{
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending email notification to " + user.getFirstName() + ": " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending SMS notification to " + user.getFirstName() + ": " + message);
    }
}

class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending WhatsApp notification to " + user.getFirstName() + ": " + message);
    }
}
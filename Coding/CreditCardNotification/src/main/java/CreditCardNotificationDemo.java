import Notification.EmailNotification;
import Notification.Notification;
import pojo.User;
import Notification.Broadcast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCardNotificationDemo {
    public static void main(String[] args) {
        User user1 = new User("Lichu", "Jiang", "email", "lj2231@nyu.edu");
        User user2 = new User("Xiaohong", "Wang", "sms", "9298682019");
        User user3 = new User("Xiaoming", "Li", "whatsapp", "13248572");

        user1.sendNotification("you have successfully registered to add and here is your , please use this for \n" +
                "future references");
        System.out.println();
        user2.sendNotification("you have successfully registered to add and here is your , please use this for \n" +
                "future references");
        System.out.println();
        user3.sendNotification("you have successfully registered to add and here is your , please use this for \n" +
                "future references");
        System.out.println();

        List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3));
        Notification broadcast = new Broadcast(userList);
        broadcast.sendNotification("40% off when you buy Popeyes between 06/13 - 06/19");

    }
}


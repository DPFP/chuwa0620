import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("John", "123@gmail.com", NotificationPreference.EMAIL);
        User user2 = new User("Alice", "123456789", NotificationPreference.SMS);
        User user3 = new User("Bob", "987654321", NotificationPreference.WHATSAPP);

        NotificationFactory.addUser(user1);
        NotificationFactory.addUser(user2);
        NotificationFactory.addUser(user3);

        NotificationFactory.sendNotification(user1);
        NotificationFactory.sendNotification(user2);
        NotificationFactory.sendNotification(user3);

        // Broadcast public notification to all users
        NotificationFactory.broadcastNotification(" 40 % off when you buy Popeyes between 06 / 13 - 06 / 19");
    }
}

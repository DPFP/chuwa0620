import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Create test users
        User user1 = new User("Tom","Tom@xx.com","111", User.preference.WHATSAPP);
        User user2 = new User("Sam","Sam@xx.com","222", User.preference.EMAIL);
        User user3 = new User("Jim","Jim@xx.com","333", User.preference.SMS);
        User user4 = new User("Angle","Angle@xx.com","444", User.preference.WHATSAPP);

        //Append test users to array
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        //Add to broadcast method
        Broadcast broadcast = new Broadcast(users);
        broadcast.broadcastALL("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}

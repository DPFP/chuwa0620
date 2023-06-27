import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class NotificationSystem {
    private static Set<User> userSet = new HashSet<>();

    private EmailNotification email = new EmailNotification();
    private SMSNotification sms = new SMSNotification();
    private WhatsappNotification what = new WhatsappNotification();

    public int addUser(User user) {
        userSet.add(user);
        register(user);
        return 0;
    }

    public int register(User user) {
        if (user.getNotificationType() == "EMAIL") {
            email.register(user);
        }
        if (user.getNotificationType() == "SMS") {
            sms.register(user);
        }
        if (user.getNotificationType() == "WHATSAPP") {
            what.register(user);
        }
        return 0;
    }


    public int broadcast(String msg) {
        for (User user : userSet) {
            if (user.getNotificationType() == "EMAIL") {
                email.notify(user, msg);
            }
            if (user.getNotificationType() == "SMS") {
                sms.notify(user, msg);
            }
            if (user.getNotificationType() == "WHATSAPP") {
                what.notify(user, msg);
            }
        }
        return 0;
    }
}

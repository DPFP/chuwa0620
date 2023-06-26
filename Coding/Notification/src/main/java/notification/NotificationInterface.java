package notification;

import user.User;

public interface NotificationInterface {
    void notifyUser(User user, String msg);
    void broadCast(String msg);
    void registerUser(User user);
}

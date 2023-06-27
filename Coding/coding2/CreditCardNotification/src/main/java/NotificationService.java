public interface NotificationService{

    int register(User user);

    int notify(User user, String msg);
}

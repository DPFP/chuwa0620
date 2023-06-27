public class EmailNotification implements NotificationService{
    @Override
    public int register(User user) {
        String msg =
                String.format("Hey %s, you have successfully registered to add %s, and here is your number %s, " +
                "please use this for future references",
                user.getFirstName(), user.getNotificationType(), user.getContactsMap().get(user.getNotificationType()));
        notify(user, msg);
        return 0;
    }

    @Override
    public int notify(User user, String msg) {
        System.out.println(msg);
        System.out.println("From Email");
        return 0;
    }
}

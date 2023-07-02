public class Main {
    public static void main(String[] args) {
        User user1 = new User("Tom", Type.Email);
        User user2 = new User("Jack", Type.SMS);
        User user3 = new User("John", Type.WHATSAPP);


        NotificationService service = new NotificationService();
        service.sendMsgByType(user1);
        service.sendMsgByType(user2);
        service.sendMsgByType(user3);
        service.broadAll(user1, "40% off when you buy Popeyes between 06/13 - 06/19");
    }
}

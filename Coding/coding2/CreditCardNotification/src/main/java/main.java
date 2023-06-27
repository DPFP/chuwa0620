public class main {
    public static void main(String[] args) {
        NotificationSystem sys = new NotificationSystem();

        User u1 = new User("ABC", "EMAIL", "123@qq.com");
        User u2 = new User("qwe", "SMS", "5287543");
        User u3 = new User("Jack", "WHATSAPP", "whats1234");

        sys.addUser(u1);
        sys.addUser(u2);
        sys.addUser(u3);


        sys.broadcast("Broadcasting");
    }
}

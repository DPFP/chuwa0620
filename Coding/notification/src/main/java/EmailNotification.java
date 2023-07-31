public class EmailNotification implements SendMsg{
    @Override
    public void send(String msg) {
        System.out.println("Email notification: " + msg);
    }
}

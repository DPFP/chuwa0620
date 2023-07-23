public class SMSNotification implements SendMsg{
    @Override
    public void send(String msg) {
        System.out.println("SMS notification: " + msg);
    }
}

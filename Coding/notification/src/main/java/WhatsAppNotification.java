public class WhatsAppNotification implements SendMsg{
    @Override
    public void send(String msg) {
        System.out.println("WhatsApp notification: " + msg);
    }
}

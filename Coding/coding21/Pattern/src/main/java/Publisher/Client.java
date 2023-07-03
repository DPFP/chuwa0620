package Publisher;


public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeiXinUser("123"));
        subject.attach(new WeiXinUser("345"));
        subject.attach(new WeiXinUser("6767"));

        subject.notify("notify");
    }
}

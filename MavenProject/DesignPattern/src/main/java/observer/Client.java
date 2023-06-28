package observer;

public class Client {
    public static void main(String[] args) {
        // subject create
        SubscriptionSubject subject = new SubscriptionSubject();

        // subscribe subject
        subject.attach(new WeixinUser("孙悟空"));
        subject.attach(new WeixinUser("猪悟能"));
        subject.attach(new WeixinUser("沙悟净"));

        // subject update information
        subject.notify("It is time to update");
    }
}

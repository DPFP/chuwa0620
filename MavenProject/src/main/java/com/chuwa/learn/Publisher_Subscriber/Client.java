package com.chuwa.learn.Publisher_Subscriber;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject publisher = new SubscriptionSubject();
        publisher.attach(new User("ToT"));
        publisher.attach(new User("Max"));
        User user1 = new User("Blao");
        publisher.attach(user1);
        publisher.notify("Wassup");
        publisher.detach(user1);
        publisher.notify("Wassup 2");
    }
}

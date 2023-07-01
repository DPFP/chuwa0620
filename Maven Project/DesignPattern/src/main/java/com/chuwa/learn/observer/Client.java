package com.chuwa.learn.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject publisher = new SubscriptionSubject();
        User user1 = new User("Tom");
        User user2 = new User("Max");
        User user3 = new User("Bob");
        publisher.attach(user1);
        publisher.attach(user2);
        publisher.attach(user3);
        publisher.notify("Welcome!");
        publisher.detach(user3);
        publisher.notify("Bob has gone.");
    }
}

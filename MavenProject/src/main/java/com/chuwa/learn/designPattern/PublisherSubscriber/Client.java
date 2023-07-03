package com.chuwa.learn.designPattern.PublisherSubscriber;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
        subscriptionSubject.attach(new WeiXinUser("Mia"));
        subscriptionSubject.attach(new WeiXinUser("Joe"));
        subscriptionSubject.attach(new WeiXinUser("Ben"));
        subscriptionSubject.attach(new WeiXinUser("Jeremy"));
        subscriptionSubject.notify("New update!");
    }
}

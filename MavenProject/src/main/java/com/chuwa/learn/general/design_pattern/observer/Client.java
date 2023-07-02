package com.chuwa.learn.general.design_pattern.observer;

public class Client {

    public static void main(String[] args) {
        // create subject
        SubscriptionSubject subject = new SubscriptionSubject();

        // subscribe
        subject.attach(new WechatUser("A"));
        subject.attach(new WechatUser("B"));
        subject.attach(new WechatUser("C"));

        // update send msg
        subject.notify("hello");
    }
}

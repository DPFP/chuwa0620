package com.chuwa.learn.pattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WeiXinUser("孙悟空"));
        subject.attach(new WeiXinUser("猪八戒"));
        subject.attach(new WeiXinUser("沙僧"));

        subject.notify("chuwa专栏更新了");
    }
}

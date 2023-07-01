package org.example.observer;

public class Client {
    public static void main(String[] args) {
        // 创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();
        //订阅公众号
        subject.attach(new WeiXinUser("111"));
        subject.attach(new WeiXinUser("222"));
        subject.attach(new WeiXinUser("333"));

        subject.notify("gengxin");
    }
}

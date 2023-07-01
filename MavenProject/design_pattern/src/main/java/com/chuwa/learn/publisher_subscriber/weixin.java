package com.chuwa.learn.publisher_subscriber;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}

interface Subject {
    //添加订阅者（添加观察者对象）
    void attach(Observer observer);
    //删除订阅者
    void detach(Observer observer);
    //通知订阅者更新消息
    void notify(String message);
}

class SubscriptionSubject implements Subject {
    private List<Observer> UserList = new ArrayList<Observer>();

    public void attach(Observer observer) {
        UserList.add(observer);
    }

    public void detach(Observer observer) {
        UserList.remove(observer);
    }

    public void notify(String message) {
        for (Observer observer : UserList) {
            observer.update(message);
        }
    }
}

public class weixin {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        //订阅
        subject.attach(new WeiXinUser("Jacob"));
        subject.attach(new WeiXinUser("Jane"));
        subject.attach(new WeiXinUser("Jasper"));

        //发出消息给订阅者（观察者对象）
        subject.notify("New Update!");
    }
}

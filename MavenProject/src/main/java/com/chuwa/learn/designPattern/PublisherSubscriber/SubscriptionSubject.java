package com.chuwa.learn.designPattern.PublisherSubscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{
    private List<Observer> userList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void detch(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : userList) {
            observer.update(message);
        }
    }
}

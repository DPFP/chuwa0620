package com.chuwa.learn.general.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject {

    // define a list of observer
    private List<Observer> wechatUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        wechatUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        wechatUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : wechatUserList) {
            observer.update(message);
        }
    }
}

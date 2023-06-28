package com.chuwa.learn.Publisher_Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{
    private List<Observer> List = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        List.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        List.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer: List) {
            observer.update(message);
        }
    }
}

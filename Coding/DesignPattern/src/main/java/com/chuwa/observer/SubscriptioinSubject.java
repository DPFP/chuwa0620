package com.chuwa.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptioinSubject implements Subject{
    private List<Observer> observerList = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer observer : observerList) {
            observer.update(msg);
        }
    }
}

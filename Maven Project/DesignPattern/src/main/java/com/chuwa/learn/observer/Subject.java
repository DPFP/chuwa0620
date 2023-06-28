package com.chuwa.learn.observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String msg);
}

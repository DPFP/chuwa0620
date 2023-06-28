package com.chuwa.learn.general.design_pattern.observer;

// title subject
public interface Subject {

    // add observer
    void attach(Observer observer);

    // delete observer
    void detach(Observer observer);

    // notify observer
    void notify(String message);
}

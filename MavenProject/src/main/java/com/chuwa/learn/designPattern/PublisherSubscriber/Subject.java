package com.chuwa.learn.designPattern.PublisherSubscriber;

public interface Subject {
    void attach(Observer observer);
    void detch(Observer observer);

    void notify(String message);
}

package com.chuwa.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptioinSubject subscriptioinSubject = new SubscriptioinSubject();
        subscriptioinSubject.attach(new User("Joe"));
        subscriptioinSubject.attach(new User("Grace"));
        subscriptioinSubject.attach(new User("Elon"));

        subscriptioinSubject.notify("update");


    }


}

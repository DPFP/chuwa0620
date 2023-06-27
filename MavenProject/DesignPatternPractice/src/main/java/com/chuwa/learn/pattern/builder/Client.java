package com.chuwa.learn.pattern.builder;

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());
        Bike bike = director.construct();
    }
}

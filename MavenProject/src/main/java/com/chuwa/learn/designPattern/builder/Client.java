package com.chuwa.learn.designPattern.builder;

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());
        Bike bike = director.constructor();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}

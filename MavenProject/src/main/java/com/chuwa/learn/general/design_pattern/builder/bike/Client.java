package com.chuwa.learn.general.design_pattern.builder.bike;

public class Client {

    public static void main(String[] args) {
        // create director
        Director director = new Director(new MobileBuilder());

        // let director to create bike
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}

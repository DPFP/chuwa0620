package com.chuwa.learn.builder;

public class Client {
    public static void main(String[] args) {
        Director director1 = new Director(new MobikeBuilder());
        Director director2 = new Director(new OfoBuilder());

        Bike mobike = director1.construct();
        Bike ofo = director2.construct();

        System.out.println("Mobike frame: " + mobike.getFrame());
        System.out.println("Ofo seat: " + ofo.getSeat());
    }
}

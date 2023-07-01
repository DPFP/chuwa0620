package com.chuwa.learn.Builder;

public class Client {
    public static void main(String[] args) {
        Director director_1 = new Director(new MobileBuilder());
        Director director_2 = new Director(new OfoBuilder());

        Bike mobike = director_1.construct();
        Bike ofo = director_2.construct();

        System.out.println("Mobike frame: " + mobike.getFrame());
        System.out.println("Ofo seat: " + ofo.getSeat());
    }
}

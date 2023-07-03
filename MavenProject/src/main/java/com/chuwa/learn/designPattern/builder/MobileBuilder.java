package com.chuwa.learn.designPattern.builder;

public class MobileBuilder extends Builder {

    @Override
    public void buildFrame() {
        bike.setFrame("Frame 1");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Seat 1");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

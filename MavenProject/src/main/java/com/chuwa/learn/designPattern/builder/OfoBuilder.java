package com.chuwa.learn.designPattern.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Frame 2");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Seat 2");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

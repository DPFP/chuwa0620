package com.chuwa.learn.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setSeat("Alloy frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Plastic seat");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}

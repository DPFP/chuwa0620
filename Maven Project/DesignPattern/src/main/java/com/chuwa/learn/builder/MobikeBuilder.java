package com.chuwa.learn.builder;

public class MobikeBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Carbon fiber frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather seat");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}

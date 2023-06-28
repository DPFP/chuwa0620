package com.chuwa.Builder;

public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("carbon fiber");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("leather seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

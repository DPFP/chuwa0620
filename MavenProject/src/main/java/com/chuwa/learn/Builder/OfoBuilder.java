package com.chuwa.learn.Builder;

public class OfoBuilder extends  Builder{
    @Override
    public void buildFrame() {
        aBike.setFrame("carbon fiber");
    }

    @Override
    public void buildSeat() {
        aBike.setSeat("leather seat");
    }

    @Override
    public Bike buildBike() {
        return aBike;
    }
}

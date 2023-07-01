package org.example.builder;

public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Tanxianwei");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("zhenpi");

    }

    @Override
    public Bike createrBike() {
        return bike;
    }
}

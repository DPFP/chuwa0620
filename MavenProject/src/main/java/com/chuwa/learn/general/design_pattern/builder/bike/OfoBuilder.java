package com.chuwa.learn.general.design_pattern.builder.bike;

/**
 * ofo builder
 */
public class OfoBuilder extends Builder {

    @Override
    public void builderFrame() {
        bike.setFrame("type 2 frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("type 2 seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

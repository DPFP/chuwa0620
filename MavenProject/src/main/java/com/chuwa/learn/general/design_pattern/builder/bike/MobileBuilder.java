package com.chuwa.learn.general.design_pattern.builder.bike;

/**
 * builder to build mobile bike object
 */
public class MobileBuilder extends Builder {
    @Override
    public void builderFrame() {
        bike.setFrame("type 1 frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("type 1 seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

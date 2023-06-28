package com.chuwa.learn.general.design_pattern.builder.bike;

/**
 * constructor
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // build bike
    public Bike construct() {
        builder.builderFrame();
        builder.buildSeat();
        return builder.createBike();
    }

}

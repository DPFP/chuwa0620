package com.chuwa.learn.general.design_pattern.builder.bike;

public abstract class Builder {

    // Declare Bike type variable and set value
    protected Bike bike = new Bike();

    public abstract void builderFrame();

    public abstract void buildSeat();

    // method to construct bike
    public abstract Bike createBike();
}

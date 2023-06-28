package com.chuwa.learn.Builder;

public abstract class Builder {
    protected Bike aBike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract Bike buildBike();
}

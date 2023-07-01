package com.chuwa.Builder;

public class Director {
    public Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike constructor() {
        builder.buildSeat();
        builder.buildFrame();

        return builder.createBike();
    }
}

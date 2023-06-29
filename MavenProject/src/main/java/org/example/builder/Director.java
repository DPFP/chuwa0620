package org.example.builder;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public Bike constructor(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createrBike();
    }
}

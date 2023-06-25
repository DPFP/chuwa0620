package org.example;

public class Bike implements Vehicle {
    private String bikeNumber;

    public Bike(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    @Override
    public String toString() {
        return "bike number=" + bikeNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}

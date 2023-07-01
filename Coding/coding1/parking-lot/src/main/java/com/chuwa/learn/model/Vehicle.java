package com.chuwa.learn.model;

public class Vehicle {
    private String vehicleNumber;
    private VehicleSize size;

    public Vehicle(String vehicleNumber, VehicleSize size) {
        this.vehicleNumber = vehicleNumber;
        this.size = size;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }
}

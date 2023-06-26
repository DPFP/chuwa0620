package com.chuwa;

public class ParkingSpot {
    int id;
    boolean parked = false;
    int size;

    Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isParked() {
        return parked;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean park(Vehicle vehicle) {
        if(isParked()) return false;
        vehicle = vehicle;
        parked = true;
        return parked;
    }

    public boolean leave() {
        if(!isParked()) return false;
        vehicle = null;
        parked = false;
        return true;
    }
}

package com.chuwa;

public class Vehicle {
    int size;
    int id;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle(int size, int id) {
        this.size = size;
        this.id = id;
    }

    public boolean ifFitSpot(ParkingSpot spot){
        return spot.size <= size;
    }

}



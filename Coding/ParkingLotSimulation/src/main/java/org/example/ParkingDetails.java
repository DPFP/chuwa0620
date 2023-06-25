package org.example;

import java.util.Date;

public class ParkingDetails {
    Vehicle vehicle;
    Parking parking;
    Date entryTime;
    Date exitTime;

    public ParkingDetails(Vehicle vehicle, Parking parking, Date entryTime, Date exitTime) {
        this.vehicle = vehicle;
        this.parking = parking;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}

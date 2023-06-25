package com.chuwa.learn;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

class ParkingLot {
    private int capacity;
    private List<Vehicle> parkedVehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkedVehicles = new ArrayList<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (parkedVehicles.size() >= capacity) {
            System.out.println("Parking lot is full. Cannot park the vehicle.");
            return false;
        }

        parkedVehicles.add(vehicle);
        System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " is parked.");
        return true;
    }

    public void removeVehicle(Vehicle vehicle) {
        if (parkedVehicles.remove(vehicle)) {
            System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " is removed from the parking lot.");
        } else {
            System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " is not found in the parking lot.");
        }
    }
}

public class App
{
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);

        Vehicle vehicle1 = new Vehicle("ABC123");
        Vehicle vehicle2 = new Vehicle("XYZ789");
        Vehicle vehicle3 = new Vehicle("DEF456");
        Vehicle vehicle4 = new Vehicle("GHI789");
        Vehicle vehicle5 = new Vehicle("JKL012");
        Vehicle vehicle6 = new Vehicle("MNO345");

        parkingLot.parkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);
        parkingLot.parkVehicle(vehicle3);
        parkingLot.parkVehicle(vehicle4);
        parkingLot.parkVehicle(vehicle5);
        parkingLot.parkVehicle(vehicle6); // This will fail since the parking lot is full

        parkingLot.removeVehicle(vehicle3);
        parkingLot.removeVehicle(new Vehicle("PQR678")); // Vehicle not found

        parkingLot.parkVehicle(new Vehicle("PQR678")); // This will succeed since there is an available space now
    }
}

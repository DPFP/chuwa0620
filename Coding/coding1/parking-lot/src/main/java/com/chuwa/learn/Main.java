package com.chuwa.learn;

import com.chuwa.learn.exception.InvalidVehicleNumberException;
import com.chuwa.learn.exception.ParkingFullException;
import com.chuwa.learn.exception.WrongSizeException;
import com.chuwa.learn.model.*;

public class Main {
    public static void main(String[] args) throws ParkingFullException, InvalidVehicleNumberException, WrongSizeException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();

        parkingLot.init(10, 10);

        Vehicle vehicle = new Vehicle("Mh12", VehicleSize.TWOWHEELER);

        Ticket ticket = parkingLot.park(vehicle);
        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle("Mh13", VehicleSize.FOURWHEELER);

        Ticket ticket2 = parkingLot.park(vehicle2);
        System.out.println(ticket2);

        int cost1 = parkingLot.checkout(ticket2, new TwoWheelerCharge());
        System.out.println(cost1);

        int cost2 = parkingLot.checkout(ticket2, new FourWheelerCharge());
        System.out.println(cost2);

    }
}
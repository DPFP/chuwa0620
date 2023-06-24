package com.chuwa.learn.intf;

import com.chuwa.learn.exception.InvalidVehicleNumberException;
import com.chuwa.learn.exception.ParkingFullException;
import com.chuwa.learn.exception.WrongSizeException;
import com.chuwa.learn.model.Ticket;
import com.chuwa.learn.model.Vehicle;

public interface Parking {
    public Ticket park(Vehicle vehicle) throws ParkingFullException, WrongSizeException;
    public int checkout(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException, InvalidVehicleNumberException, WrongSizeException;
}

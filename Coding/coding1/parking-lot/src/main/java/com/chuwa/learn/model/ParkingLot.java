package com.chuwa.learn.model;

import com.chuwa.learn.exception.InvalidVehicleNumberException;
import com.chuwa.learn.exception.ParkingFullException;
import com.chuwa.learn.exception.WrongSizeException;
import com.chuwa.learn.intf.Parking;
import com.chuwa.learn.intf.ParkingChargeStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot implements Parking {
    //Singleton
    private static ParkingLot parkingLot = null;
    private final List<Slot> twoWheelerSlots;
    private final List<Slot> fourWheelerSlots;

    // private constructor to make sure singleton
    private ParkingLot() {
        this.twoWheelerSlots = new ArrayList<>();
        this.fourWheelerSlots = new ArrayList<>();
    }

    // parking lot can only be access by method
    public static ParkingLot getParkingLot() {
        if(parkingLot == null){
            return new ParkingLot();
        }else{
            return parkingLot;
        }
    }

    public boolean init(int numTwoWheeler, int numFourWheeler){
        for(int i = 0;i < numTwoWheeler;i++){
            this.twoWheelerSlots.add(new Slot(i));
        }
        for(int i = 0;i < numFourWheeler;i++){
            this.fourWheelerSlots.add(new Slot(i));
        }
        return true;
    }

    private Slot getNextAvailableTwoWheelerSlot() throws ParkingFullException {
        for (Slot slot : twoWheelerSlots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Slot available");
    }
    private Slot getNextAvailableFourWheelerSlot() throws ParkingFullException {
        for (Slot slot : fourWheelerSlots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Slot available");
    }

    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException, WrongSizeException {
        Slot nextAvaliableSlot;
        if(vehicle.getSize().equals(VehicleSize.FOURWHEELER)){
            nextAvaliableSlot = getNextAvailableFourWheelerSlot();
        }else if(vehicle.getSize().equals(VehicleSize.TWOWHEELER)){
            nextAvaliableSlot = getNextAvailableTwoWheelerSlot();
        }else{
            throw new WrongSizeException("Wrong size of vehicle");
        }

        Ticket ticket = new Ticket(nextAvaliableSlot.getSlotNumber(), vehicle.getVehicleNumber(), vehicle.getSize(),new Date());
        nextAvaliableSlot.occupySlot();
        return ticket;
    }

    @Override
    public int checkout(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException, WrongSizeException{
        VehicleSize vehicleSize = ticket.getVehicleSize();
        int hours = getHoursParked(ticket.getDate(),new Date());
        int cost;
        Slot slot = null;
        if(vehicleSize.equals(VehicleSize.TWOWHEELER)){
            slot = this.twoWheelerSlots.get(ticket.getSlotNumber());

        }else if(vehicleSize.equals(VehicleSize.FOURWHEELER)){
            slot = this.fourWheelerSlots.get(ticket.getSlotNumber());
        }else{
            throw new WrongSizeException("Wrong vehicle size");
        }
        if(slot == null){
            throw new InvalidVehicleNumberException("Wrong slot");
        }else{
            slot.vacateSlot();
        }
        cost = parkingCostStrategy.getCharges(hours);
        return cost;
    }

    private int getHoursParked(Date startDate, Date endDate) {
        long secs = (endDate.getTime() - startDate.getTime()) / 1000;
        int hours = (int) (secs / 3600);
        return hours;
    }
}

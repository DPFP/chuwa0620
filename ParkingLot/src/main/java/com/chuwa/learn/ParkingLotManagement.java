package com.chuwa.learn;

import java.util.List;

public class ParkingLotManagement {
    private ParkingLot parkingLot;
    private List<Vehicle> vehicles;

    public ParkingLotManagement(ParkingLot parkingLot,List<Vehicle> vehicles){
        this.parkingLot = parkingLot;
        this.vehicles = vehicles;
    }
    public String findSpot(){
        if(parkingLot.getFreeSpotNum() == 0){
            return null;
        }
        String spot = parkingLot.getEmptySpot().get(true).get(0);
        return spot;
    }

    public void parkCar(Vehicle car){
        String spot = findSpot();
        car.setSpotId(spot);
        vehicles.add(car);
        parkingLot.parkCar(car, spot);
    }

    public void leaveCar(Vehicle car){
        vehicles.remove(car);
        parkingLot.leavecar(car);
    }
}

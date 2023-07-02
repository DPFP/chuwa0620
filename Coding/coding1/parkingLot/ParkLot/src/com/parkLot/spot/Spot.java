package com.parkLot.spot;

import com.parkLot.vehicle.Vehicle;

public class Spot {
    private SpotType spotType;
    private Vehicle vehicle;

    public Spot(SpotType spotType){
        this.spotType = spotType;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public boolean park(Vehicle vehicle){
        return false;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}

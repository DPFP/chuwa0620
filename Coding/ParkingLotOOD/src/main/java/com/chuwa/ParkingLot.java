package com.chuwa;
import com.chuwa.ParkingSpot;
import com.chuwa.Vehicle;

import java.util.HashMap;
import java.util.List;



public class ParkingLot {
    List<ParkingSpot> spots;
    HashMap<Integer, ParkingSpot> parkedCar = new HashMap<>();
    int numSpots;

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public HashMap<Integer, ParkingSpot> getParkedCar() {
        return parkedCar;
    }

    public void setParkedCar(HashMap<Integer, ParkingSpot> parkedCar) {
        this.parkedCar = parkedCar;
    }

    public int getNumSpots() {
        return numSpots;
    }

    public void setNumSpots(int numSpots) {
        this.numSpots = numSpots;
    }

    public boolean Park(Vehicle vehicle){
        ParkingSpot spot = findFitSpot(vehicle);
        if(spot == null) return false;
        if(!spot.park(vehicle)) {
            parkedCar.put(vehicle.getId(), spot);
            return true;
        }
        return false;

    }

    public ParkingSpot findFitSpot(Vehicle vehicle) {
        if(parkedCar.size() == numSpots) return null;
        for(ParkingSpot s : spots) {
            if(!s.isParked() && vehicle.ifFitSpot(s)) {
                return s;
            }
        }
        return null;
    }

    public boolean leave(Vehicle vehicle) {
        ParkingSpot spot = parkedCar.getOrDefault(vehicle.getId(), null);
        if(spot == null || spot.getVehicle().getId() != vehicle.getId()) return false;
        if(spot.leave()) {
            parkedCar.remove(vehicle.getId());
            return true;
        }
        return false;
    }

}

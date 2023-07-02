package parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private final List<ParkingSpot> spots;

    public ParkingLevel(int numSpots) {
        this.spots = new ArrayList<>();
        // spots assignment: 20% for large, 20% compact, rest is motorcycle
        int i=0;
        for(;i<numSpots/5;i++){
            spots.add(new ParkingSpot(VehicleSize.Large));
        }
        for(;i<numSpots*2/5;i++){
            spots.add(new ParkingSpot(VehicleSize.Compact));
        }
        for(;i<numSpots;i++){
            spots.add(new ParkingSpot(VehicleSize.MotorCycle));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot:spots){
            if(spot.fit(vehicle)){
                spot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean leaveVehicle(Vehicle vehicle){
        for(ParkingSpot spot:spots){
            if(spot.getCurrentVehicle() == vehicle){
                spot.leave();
                return true;
            }
        }
        return false;
    }
}

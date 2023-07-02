package parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<ParkingLevel> levels;

    public ParkingLot(int numLevels, int numSpotsPreLevel) {
        levels = new ArrayList<>();
        for(int i=0;i<numLevels;i++){
            levels.add(new ParkingLevel(numSpotsPreLevel));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingLevel level:levels){
            if(level.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void leaveVehicle(Vehicle vehicle){
        for(ParkingLevel level:levels){
            if(level.leaveVehicle(vehicle)){
                return;
            }
        }
    }
}

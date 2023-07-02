package parkingLot.vehicle;

import parkingLot.Vehicle;
import parkingLot.VehicleSize;

public class MotorCycle extends Vehicle {
    public MotorCycle(String licensePlate) {
        super(VehicleSize.MotorCycle, licensePlate);
    }
}

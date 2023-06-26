package parkingLot.vehicle;

import parkingLot.Vehicle;
import parkingLot.VehicleSize;

public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(VehicleSize.Large, licensePlate);
    }
}

package parkingLot.vehicle;

import parkingLot.Vehicle;
import parkingLot.VehicleSize;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(VehicleSize.Compact, licensePlate);
    }
}

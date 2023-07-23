import java.util.*;

import static java.util.Arrays.asList;

public enum SlotSize {
    SMALL(Arrays.asList(VehicleType.BIKE, VehicleType.COMPACT)),
    MEDIUM(Arrays.asList(VehicleType.BIKE, VehicleType.COMPACT, VehicleType.SEDAN)),
    LARGE(Arrays.asList(VehicleType.BIKE, VehicleType.COMPACT, VehicleType.SEDAN, VehicleType.TRUCK));

    private final List<VehicleType> vehicleTypesAllowed;

    SlotSize(List<VehicleType> vehicleTypes) {
        this.vehicleTypesAllowed = vehicleTypes;
    }

    public boolean isVehicleParkingPossible(Vehicle vehicle) {
        return vehicleTypesAllowed.contains(vehicle.getType());
    }
}

package yuming;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FareController {
    private Map<Vehicle, ParkingDetails> vehicleParkingDetailsMap = new HashMap<>();

    public void onVehicleEntry(Vehicle vehicle, Parking parking) {
        vehicleParkingDetailsMap.put(vehicle, new ParkingDetails(vehicle, parking, new Date(), null));
    }

    public void onVehicleExit(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        parkingDetails.exitTime = new Date();
    }

    public BigDecimal getFare(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        return getFare(parkingDetails.parking, parkingDetails.entryTime, parkingDetails.exitTime);
    }

    private BigDecimal getFare(Parking parking, Date entryTime, Date exitTime) {
        // Implement your fare calculation logic here
        return BigDecimal.ZERO;
    }
}

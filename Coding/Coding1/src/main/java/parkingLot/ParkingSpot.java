package parkingLot;

public class ParkingSpot {
    private final VehicleSize spotSize;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleSize spotSize) {
        this.spotSize = spotSize;
    }

    public boolean fit(Vehicle vehicle){
        return currentVehicle == null && spotSize.ordinal() >= vehicle.getVehicleSize().ordinal();
    }

    public void park(Vehicle vehicle){
        currentVehicle = vehicle;
    }

    public void leave(){
        currentVehicle = null;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }
}

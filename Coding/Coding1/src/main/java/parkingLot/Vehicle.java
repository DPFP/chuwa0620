package parkingLot;


public abstract class Vehicle {
    private VehicleSize vehicleSize;
    private String licensePlate;

    public Vehicle(VehicleSize vehicleSize, String licensePlate){
        this.vehicleSize = vehicleSize;
        this.licensePlate = licensePlate;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

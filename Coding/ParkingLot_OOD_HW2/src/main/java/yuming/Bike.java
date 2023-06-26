package yuming;

public class Bike implements Vehicle{
    private String bikeNumber;
    public Bike(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }
    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}

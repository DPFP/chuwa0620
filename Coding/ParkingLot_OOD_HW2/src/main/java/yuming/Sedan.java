package yuming;

public class Sedan implements Vehicle {
    private String carNumber;

    public Sedan(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SEDAN;
    }
}

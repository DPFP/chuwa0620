public class Sedan implements Vehicle {

    private String carNumber;

    public Sedan(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "car number=" + carNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SEDAN;
    }

}
public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, Size.MEDIUM);
    }

    @Override
    public String getType() {
        return "Car";
    }
}

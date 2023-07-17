public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate, Size.LARGE);
    }

    @Override
    public String getType() {
        return "Bus";
    }
}

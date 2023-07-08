public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, Size.SMALL);
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}

public abstract class Vehicle {
    private String licensePlate;
    private Size size;

    public Vehicle(String licensePlate, Size size) {
        this.licensePlate = licensePlate;
        this.size = size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Size getSize() {
        return size;
    }

    public abstract String getType();
}


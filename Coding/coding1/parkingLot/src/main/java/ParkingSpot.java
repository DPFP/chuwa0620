// ParkingSpot.java (修改后的代码)
public class ParkingSpot {
    private int number;
    private boolean occupied;
    private Vehicle vehicle;
    private Size size;

    public ParkingSpot(int number, Size size) {
        this.number = number;
        this.size = size;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void release() {
        this.vehicle = null;
        this.occupied = false;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return size.getSizeValue() >= vehicle.getSize().getSizeValue();
    }

    public int getSpotNumber() {
        return number;
    }
}

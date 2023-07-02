import lombok.Data;

@Data
public class SingleParkingPlace {

    private boolean isOccupied;

    private Vehicle OccupiedVehicle;

    public SingleParkingPlace() {
        isOccupied = false;
        OccupiedVehicle = null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (isOccupied) {
            return false;
        }

        try {
            isOccupied = true;
            OccupiedVehicle = vehicle;
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean removeVehicle() {
        if (isOccupied) {
            isOccupied = false;
            OccupiedVehicle = null;
            return true;
        }
        return false;
    }

}

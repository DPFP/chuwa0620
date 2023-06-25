import lombok.Data;


@Data
public class ParkingLot {

    private SingleParkingPlace[] places;

    private int totalPlace;

    public ParkingLot(int totalPlace) {
        this.totalPlace = totalPlace;
        places = new SingleParkingPlace[totalPlace];

        for (int i = 0; i < totalPlace; i++) {
            places[i] = new SingleParkingPlace();
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        int index = 0;
        for (SingleParkingPlace place : places) {
            if (place.parkVehicle(vehicle)) {
                System.out.println("vehicle with license:" + vehicle.getLicense() + " is parked in lot:" + index);
                return true;
            }
            index++;
        }
        // no place
        System.out.println("no enough space");
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (SingleParkingPlace place : places) {
            if (place.getOccupiedVehicle() != null && place.getOccupiedVehicle().equals(vehicle)) {
                place.removeVehicle();
            }
        }
        // no such vehicle
        System.out.println("no such vehicle");
        return false;
    }

}

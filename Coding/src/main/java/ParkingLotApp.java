import java.util.*;

public class ParkingLotApp {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10); // Create a parking lot with 10 spaces

        Vehicle vehicle1 = new Vehicle("ABC123");
        Vehicle vehicle2 = new Vehicle("XYZ789");

        // Park vehicle 1
        Optional<ParkingSpace> availableSpace1 = parkingLot.findAvailableParkingSpace();
        if (availableSpace1.isPresent()) {
            boolean success = parkingLot.parkVehicle(availableSpace1.get());
            if (success) {
                System.out.println("Vehicle 1 parked in space " + availableSpace1.get().getNumber());
            } else {
                System.out.println("Unable to park Vehicle 1");
            }
        } else {
            System.out.println("No available parking space for Vehicle 1");
        }

        // Park vehicle 2
        Optional<ParkingSpace> availableSpace2 = parkingLot.findAvailableParkingSpace();
        if (availableSpace2.isPresent()) {
            boolean success = parkingLot.parkVehicle(availableSpace2.get());
            if (success) {
                System.out.println("Vehicle 2 parked in space " + availableSpace2.get().getNumber());
            } else {
                System.out.println("Unable to park Vehicle 2");
            }
        } else {
            System.out.println("No available parking space for Vehicle 2");
        }

        // Release parking space for vehicle 1
        parkingLot.releaseParkingSpace(availableSpace1.get());
        System.out.println("Vehicle 1 left the parking lot");

        // Park vehicle 2 (again)
        availableSpace2 = parkingLot.findAvailableParkingSpace();
        if (availableSpace2.isPresent()) {
            boolean success = parkingLot.parkVehicle(availableSpace2.get());
            if (success) {
                System.out.println("Vehicle 2 parked in space " + availableSpace2.get().getNumber());
            } else {
                System.out.println("Unable to park Vehicle 2");
            }
        } else {
            System.out.println("No available parking space for Vehicle 2");
        }
    }
}

// Enum to represent the types of parking spaces
enum ParkingSpaceType {
    COMPACT,
    REGULAR,
    HANDICAPPED
}

// Class to represent a parking space
class ParkingSpace {
    private int number;
    private ParkingSpaceType type;
    private boolean occupied;

    public ParkingSpace(int number, ParkingSpaceType type) {
        this.number = number;
        this.type = type;
        this.occupied = false;
    }

    public int getNumber() {
        return number;
    }

    public ParkingSpaceType getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void release() {
        occupied = false;
    }
}

// Class to represent a parking lot
class ParkingLot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(int totalSpaces) {
        parkingSpaces = new ArrayList<>();
        for (int i = 1; i <= totalSpaces; i++) {
            ParkingSpace space = new ParkingSpace(i, ParkingSpaceType.REGULAR);
            parkingSpaces.add(space);
        }
    }

    public Optional<ParkingSpace> findAvailableParkingSpace() {
        return parkingSpaces.stream()
                .filter(space -> !space.isOccupied())
                .findFirst();
    }

    public boolean parkVehicle(ParkingSpace space) {
        if (space.isOccupied()) {
            return false; // Space is already occupied
        }
        space.occupy();
        return true;
    }

    public void releaseParkingSpace(ParkingSpace space) {
        space.release();
    }
}

// Class to represent a vehicle
class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

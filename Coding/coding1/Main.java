import java.util.ArrayList;
import java.util.List;

class Car {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

class ParkingLot {
    private int capacity;
    private List<Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public boolean parkCar(Car car) {
        if (cars.size() < capacity) {
            cars.add(car);
            System.out.println("Car with license plate " + car.getLicensePlate() + " parked successfully.");
            return true;
        } else {
            System.out.println("Parking lot is full. Car with license plate " + car.getLicensePlate() + " cannot be parked.");
            return false;
        }
    }

    public boolean removeCar(Car car) {
        if (cars.remove(car)) {
            System.out.println("Car with license plate " + car.getLicensePlate() + " removed successfully.");
            return true;
        } else {
            System.out.println("Car with license plate " + car.getLicensePlate() + " not found in the parking lot.");
            return false;
        }
    }

    public int getAvailableSpaces() {
        return capacity - cars.size();
    }

    public int getOccupiedSpaces() {
        return cars.size();
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);

        Car car1 = new Car("ABC123");
        Car car2 = new Car("XYZ789");
        Car car3 = new Car("DEF456");
        Car car4 = new Car("GHI789");
        Car car5 = new Car("JKL012");
        Car car6 = new Car("MNO345");

        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);
        parkingLot.parkCar(car3);
        parkingLot.parkCar(car4);
        parkingLot.parkCar(car5);
        parkingLot.parkCar(car6); // This car will not be parked as the parking lot is full

        parkingLot.removeCar(car2);

        System.out.println("Available spaces: " + parkingLot.getAvailableSpaces());
        System.out.println("Occupied spaces: " + parkingLot.getOccupiedSpaces());
    }
}

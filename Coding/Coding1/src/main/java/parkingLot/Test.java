package parkingLot;

/*
 * 1. understand user case. eg what vehicle? park lot size? level?
 * 2. define related entity
 * 3. define attribute and function for each entity
 * 4. think of implementation detail for each function
 *
 * */

import parkingLot.vehicle.Bus;
import parkingLot.vehicle.Car;
import parkingLot.vehicle.MotorCycle;

public class Test {
    public static void main(String[] args) {            // create parking lot
        ParkingLot parkingLot = new ParkingLot(5, 20);

        // create vehicle
        Vehicle motorCycle = new MotorCycle("LY123");
        Vehicle car = new Car("LY223");
        Vehicle bus = new Bus("LY455");

        // Park vehicles
        System.out.println("Parking Motorcycle : "+(parkingLot.parkVehicle(motorCycle)?"Success!":"Failed!"));
        System.out.println("Parking Compact Car : "+(parkingLot.parkVehicle(car)?"Success!":"Failed!"));
        System.out.println("Parking Bus : "+(parkingLot.parkVehicle(bus)?"Success!":"Failed!"));

        // leave vehicle
        parkingLot.parkVehicle(motorCycle);
        System.out.println("Leaving Motorcycle");
        System.out.println("Leaving Compact Car");
        System.out.println("Leaving Bus");
    }

}

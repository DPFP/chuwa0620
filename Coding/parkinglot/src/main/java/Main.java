import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create some vehicles
        Vehicle bike = new Bike("Bike1");
        Vehicle car = new HatchBackCar("Car1");
        Vehicle sedan = new Sedan("Sedan1");

        // Create some parking slots
        ParkingSlot slot1 = new ParkingSlot("Slot1", "1", ParkingStatus.EMPTY, SlotSize.SMALL);
        ParkingSlot slot2 = new ParkingSlot("Slot2", "2", ParkingStatus.EMPTY, SlotSize.MEDIUM);
        ParkingSlot slot3 = new ParkingSlot("Slot3", "3", ParkingStatus.EMPTY, SlotSize.LARGE);

        // Create a floor
        Floor floor1 = new Floor("Floor1", 1, "First Floor", Arrays.asList(slot1, slot2, slot3));

        // Create a parking
        Parking parking = new Parking("Parking1", Arrays.asList(floor1), "My Parking", "123 St, Anytown");

        // Create a FareController
        FareController fareController = new FareController();

        // Park the bike
        fareController.onVehicleEntry(bike, parking);
        slot1.parkVehicle(bike);

        // Park the car
        fareController.onVehicleEntry(car, parking);
        slot2.parkVehicle(car);

        // Try to park the sedan in a slot where it's not possible
        try {
            slot2.parkVehicle(sedan);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Should print "parking not possible for this vehicle type in this slot"
        }

        // Now park the sedan in a suitable slot
        fareController.onVehicleEntry(sedan, parking);
        slot3.parkVehicle(sedan);

        // Now let's say the bike exits
        fareController.onVehicleExit(bike);
        slot1.emptySlot();
        System.out.println("Fare for bike: " + fareController.getFare(bike));  // This will print the fare for the bike

        // And so on...
    }
}
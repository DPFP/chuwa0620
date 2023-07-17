public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("My Parking Lot", 20);
        Vehicle vehicle1 = new Car("ABC123");
        Vehicle vehicle2 = new Motorcycle("XYZ789");
        Vehicle vehicle3 = new Bus("DEF456");

        ParkingSpot spot1 = parkingLot.parkVehicle(vehicle1);
        ParkingSpot spot2 = parkingLot.parkVehicle(vehicle2);
        ParkingSpot spot3 = parkingLot.parkVehicle(vehicle3);

        System.out.println("Vehicle 1 (" + vehicle1.getType() + ") parked at spot: " + spot1.getSpotNumber());
        System.out.println("Vehicle 2 (" + vehicle2.getType() + ") parked at spot: " + spot2.getSpotNumber());
        System.out.println("Vehicle 3 (" + vehicle3.getType() + ") parked at spot: " + spot3.getSpotNumber());

        parkingLot.releaseSpot(spot1);

        ParkingSpot spot4 = parkingLot.parkVehicle(vehicle1);
        System.out.println("Vehicle 1 (" + vehicle1.getType() + ") parked at spot: " + spot4.getSpotNumber());
    }
}
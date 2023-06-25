public class Test {

    public static void main(String[] args) {

        ParkingLot parkingLot= new ParkingLot(3);
        Vehicle v1 = new Vehicle("ABC", "1");
        Vehicle v2 = new Vehicle("ABCD", "2");
        Vehicle v3 = new Vehicle("ABCDE", "3");
        Vehicle v4 = new Vehicle("ABCDEF", "4");

        parkingLot.parkVehicle(v1);
        parkingLot.parkVehicle(v2);
        parkingLot.parkVehicle(v3);
        parkingLot.parkVehicle(v4);
        parkingLot.removeVehicle(v2);
        parkingLot.removeVehicle(v4);
        parkingLot.parkVehicle(v4);

        System.out.println(parkingLot);
    }
}

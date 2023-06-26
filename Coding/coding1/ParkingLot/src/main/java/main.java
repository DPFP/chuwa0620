public class main {
    public static void main(String[] args) {
        ParkingLot PL = new ParkingLot(5);
        Vehicle v1 = new Vehicle("RRR2145", "CA", "Sedan");
        Vehicle v2 = new Vehicle("4583ED", "NY", "Truck");
        Vehicle v3 = new Vehicle("ASD123", "FL", "Convertible");
        PL.vehicleEntry(v1);
        PL.vehicleEntry(v2);
        PL.vehicleExit(v2);
        PL.vehicleExit(v2);
        PL.vehicleEntry(v3);

    }
}

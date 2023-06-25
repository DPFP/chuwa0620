import java.util.HashMap;

public class ParkingLot{
    private int maxCapacity;
    private int availableSpots;
    // Hashmap stores the information about vehicle license and park time
    private HashMap<String, Integer> parkingInfo = new HashMap<>();
    // price per unit time
    private int price;

    // Constructor
    public ParkingLot(Integer capacity, Integer price){
        this.maxCapacity = capacity;
        this.availableSpots = capacity;
        this.price = price;
    }

    // Park cars
    public void parkVehicle(String license, Integer startTime){
        if(availableSpots == 0){
            System.out.println("Parking lot is full!");
        } else {
            this.parkingInfo.put(license, startTime);
            this.availableSpots--;
            System.out.println("You have successfully parked!");
        }
    }

    // Remove cars
    public void removeVehicle(String license, Integer endTime){
        // If vehicle has not parked
        if(!this.parkingInfo.containsKey(license)){
            System.out.println("Cannot find your car!");
            return;
        }
        int startTime = this.parkingInfo.get(license);
        this.availableSpots++;
        this.parkingInfo.remove(license);
        int fee = (endTime - startTime) * this.price;
        System.out.print("You have checked out, your parking fee is: ");
        System.out.println(fee);
    }
}

class Test{
    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot(3, 2);

        // Park vehicles
        parkingLot.parkVehicle("AAA", 1);
        parkingLot.parkVehicle("BBB", 2);
        parkingLot.parkVehicle("CCC", 3);
        parkingLot.parkVehicle("DDD", 4);

        // Remove vehicles
        parkingLot.removeVehicle("BBB", 5);
        parkingLot.removeVehicle("AAA", 6);
        parkingLot.removeVehicle("CCC", 7);
        parkingLot.removeVehicle("DDD", 8);
    }
}
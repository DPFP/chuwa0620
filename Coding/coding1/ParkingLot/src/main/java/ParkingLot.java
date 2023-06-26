import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class ParkingLot {
    private Set<Vehicle> lotSet;
    private Integer numOfSpace;

    public ParkingLot(int totalNum) {
        this.lotSet = new HashSet<>();
        this.numOfSpace = totalNum;
    }

    public int vehicleEntry(Vehicle v) {
        if (this.lotSet.size() >= this.numOfSpace) {
            System.out.println("Parking Lot is Full.");
            return -1;
        }
        if (this.lotSet.contains(v)) {
            System.out.println("This vehicle has already been in this Lot.");
            return -2;
        }
        this.lotSet.add(v);
        System.out.println("Vehicle Entered: \n" + v.toString());
        return 0;
    }
    public int vehicleExit(Vehicle v) {
        if (!this.lotSet.contains(v)) {
            System.out.println("This vehicle is not register in the System.");
            return -1;
        }
        this.lotSet.remove(v);
        System.out.println("Vehicle Exited: \n" + v.toString());
        return 0;
    }

}

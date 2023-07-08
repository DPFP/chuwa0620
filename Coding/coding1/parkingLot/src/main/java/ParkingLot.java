import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private int capacity;
    private List<ParkingSpot> spots;

    public ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spots = new ArrayList<>();
        initializeParkingSpots();
    }

    private void initializeParkingSpots() {
        for (int i = 0; i < capacity; i++) {
            Size size = getSizeForSpot(i); // 获取停车位的大小
            spots.add(new ParkingSpot(i, size));
        }
    }

    private Size getSizeForSpot(int spotNumber) {
        // 根据停车位编号设置不同的停车位大小
        if (spotNumber < capacity / 3) {
            return Size.SMALL; // 前一半停车位为小型车位
        } else if (spotNumber < capacity / 2) {
            return Size.LARGE;
        } else {
            return Size.MEDIUM; // 后一半停车位为中型车位
        }
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                spot.occupy(vehicle);
                return spot;
            }
        }
        return null; // No available spots
    }

    public void releaseSpot(ParkingSpot spot) {
        spot.release();
    }

    // Other methods: calculate parking fee, etc.
}
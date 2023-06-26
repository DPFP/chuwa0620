package yuming;

import java.util.List;

public class Floor {
    private String floorId;
    private int floorNumber;
    private String floorName;
    private List<ParkingSlot> parkingSlots;

    public Floor(String floorId, int floorNumber, String floorName, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
        this.floorName = floorName;
        this.parkingSlots = parkingSlots;
    }

    public void emptyFloor() {
        for (ParkingSlot slot: parkingSlots) {
            slot.emptySlot();
        }
    }
}



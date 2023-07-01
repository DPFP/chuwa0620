package org.example;

public class ParkingSlot {
    private String slotId;
    private String slotNumber;
    private ParkingStatus status;
    private SlotSize slotSize;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, String slotNumber, ParkingStatus status, SlotSize slotSize) {
        this.slotId = slotId;
        this.slotNumber = slotNumber;
        this.status = status;
        this.slotSize = slotSize;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (this.slotSize.isVehicleParkingPossible(vehicle)) {
            this.vehicle = vehicle;
            status = ParkingStatus.OCCUPIED;
        } else {
            throw new IllegalArgumentException("parking not possible for this vehicle type in this slot");
        }
    }

    public void emptySlot() {
        this.vehicle = null;
        status = ParkingStatus.EMPTY;
    }
}

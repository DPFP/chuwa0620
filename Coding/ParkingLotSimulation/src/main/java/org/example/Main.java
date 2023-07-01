package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot("001","001", ParkingStatus.EMPTY, SlotSize.MEDIUM);
        List<ParkingSlot> list = new ArrayList<>();
        list.add(slot);
        Floor floor = new Floor("01",1, "01", list);
        List<Floor> floorList = new ArrayList<>();
        floorList.add(floor);
        Parking parking = new Parking("1", floorList, "Parking Lot","1101 w 26 st");
        Sedan sedan = new Sedan("HJ456LK");
        FareController fareController = new FareController();
        fareController.onVehicleEntry(sedan, parking);
        slot.parkVehicle(sedan);
        slot.emptySlot();
        fareController.onVehicleExit(sedan);
        BigDecimal fare = fareController.getFare(sedan);
    }
}
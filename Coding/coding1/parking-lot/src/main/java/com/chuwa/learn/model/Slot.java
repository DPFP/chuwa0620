package com.chuwa.learn.model;

public class Slot {

    private int slotNumber;
    private boolean isEmpty;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        isEmpty = true;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void vacateSlot() {
        this.isEmpty = true;
    }

    public void occupySlot() {
        this.isEmpty = false;
    }
}

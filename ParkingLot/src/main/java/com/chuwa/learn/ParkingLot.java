package com.chuwa.learn;

import java.util.*;

public class ParkingLot {
    private String address;
    private String admin;
    private int totalSpotNum;
    private int freeSpotNum;
    private Hashtable<String, Vehicle> occupiedSpot;
    private HashMap<Boolean, List<String>> emptySpot;

    public ParkingLot(String address, String admin, int totalSpotNum){
        this.address = address;
        this.admin = admin;
        this.totalSpotNum = totalSpotNum;
        this.freeSpotNum = totalSpotNum;
        this.occupiedSpot = new Hashtable<>();
        this.emptySpot = new HashMap<>();
        this.emptySpot.put(true,new ArrayList<>());
        this.emptySpot.put(false,new ArrayList<>());
        for(int i = 0; i < totalSpotNum; i++){
            this.occupiedSpot.put(String.valueOf(i),null);
            this.emptySpot.get(true).add(String.valueOf(i));
        }
    }
    public String getAddress() {
        return address;
    }

    public String getAdmin() {
        return admin;
    }

    public int getFreeSpotNum() {
        return freeSpotNum;
    }

    public HashMap<Boolean, List<String>> getEmptySpot(){
        return emptySpot;
    }

    public int getTotalSpotNum() {
        return totalSpotNum;
    }

    public Vehicle checkSpot(int spotId){
        return occupiedSpot.get(spotId);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void addSpot(int spotNum) {
        for(int i = totalSpotNum; i < totalSpotNum + spotNum; i++){
            this.occupiedSpot.put(String.valueOf(i),null);
            this.emptySpot.get(true).add(String.valueOf(i));
        }
        this.totalSpotNum = totalSpotNum + spotNum;
        this.freeSpotNum = freeSpotNum + spotNum;
    }

    public void reduceSpot(int spotNum) {
        for(int i = totalSpotNum; i > totalSpotNum - spotNum; i--){
            this.occupiedSpot.remove(i);
            this.emptySpot.get(true).remove(i);
        }
        this.totalSpotNum = totalSpotNum - spotNum;
        this.freeSpotNum = freeSpotNum - spotNum;
    }

    public String parkCar(Vehicle car, String spot){
        occupiedSpot.put(spot,car);
        emptySpot.get(true).remove(0);
        emptySpot.get(false).add(spot);
        freeSpotNum -= 1;
        return "Vehicle parked successfully.";
    }

    public String leavecar(Vehicle car){
        String spot = car.getSpotId();
        occupiedSpot.put(spot,null);
        emptySpot.get(true).add(spot);
        emptySpot.get(false).remove(spot);
        freeSpotNum += 1;
        return "Vehicle leave successfully.";
    }
}

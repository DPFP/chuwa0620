package com.chuwa.learn;

public class Vehicle {
    private String plateNumber;
    private String spotId;

    public Vehicle(String plateNumber, String spotId){
        this.plateNumber = plateNumber;
        this.spotId = spotId;
    }
    public String getPlateNumber(){
        return plateNumber;
    }
    public String getSpotId(){
        return spotId;
    }
    public void setPlateNumber(String plateNumber){
        this.plateNumber = plateNumber;
    }
    public void setSpotId(String spotId){
        this.spotId = spotId;
    }
}

package com.chuwa.learn.model;

import com.chuwa.learn.intf.ParkingChargeStrategy;

public class FourWheelerCharge implements ParkingChargeStrategy {
    @Override
    public int getCharges(int hours) {
        if(hours < 1)return 10;
        return hours * 10;
    }
}

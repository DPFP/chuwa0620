package com.chuwa.learn.model;

import com.chuwa.learn.intf.ParkingChargeStrategy;

public class TwoWheelerCharge implements ParkingChargeStrategy {
    @Override
    public int getCharges(int hours) {
        if(hours < 1)return 5;
        return hours * 5;
    }
}

package org.example.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("LVhejin");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("xiangjiao");
    }

    @Override
    public Bike createrBike() {
        return bike;
    }
}

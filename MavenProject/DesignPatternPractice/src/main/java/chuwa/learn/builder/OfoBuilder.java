package chuwa.learn.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        mBike.setFrame("alumi aloy");
    }

    @Override
    public void buildSeat() {
        mBike.setSeat("rubber seat");
    }

    @Override
    public Bike createBike() {
        return mBike;
    }
}

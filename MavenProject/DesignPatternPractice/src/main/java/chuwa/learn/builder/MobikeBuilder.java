package chuwa.learn.builder;

public class MobikeBuilder extends Builder{
    @Override
    public void buildFrame() {
        mBike.setFrame("carbon fiber");
    }

    @Override
    public void buildSeat() {
        mBike.setSeat("leather seat");
    }

    @Override
    public Bike createBike() {
        return mBike;
    }
}

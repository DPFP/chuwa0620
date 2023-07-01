package builder.demo1;

public class MobileBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

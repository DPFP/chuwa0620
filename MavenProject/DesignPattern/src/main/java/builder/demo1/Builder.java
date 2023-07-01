package builder.demo1;

public abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    // construct bike
    public abstract Bike createBike();
}

package chuwa.learn.builder;

public class Director {
    private Builder builder;

    Director(Builder builder){
        this.builder = builder;
    }

    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}

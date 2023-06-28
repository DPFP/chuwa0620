package builder.demo1;

public class Client {
    public static void main(String[] args) {
        // director
        // director too complex, combine with builder
        Director director = new Director(new MobileBuilder());
        // assemble
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());

    }
}

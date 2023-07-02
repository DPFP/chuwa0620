package Factory;

public class Latte extends Coffee{

    @Override
    public String getName() {
        return "Latte";
    }

    @Override
    public String getDescription() {
        return "Espresso with steamed milk and a small layer of foam.";
    }
}

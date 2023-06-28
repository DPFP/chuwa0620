package Factory;

public class CoffeeFactory {
    public static Coffee createCoffee(String type) {
        if (type.equalsIgnoreCase("Espresso")) {
            return new Espresso();
        } else if (type.equalsIgnoreCase("Americano")) {
            return new Americano();
        } else if (type.equalsIgnoreCase("Latte")) {
            return new Latte();
        }
        return null;
    }
}

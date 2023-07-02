package Factory;

public class Client {
    public static void main(String[] args) {
        // Create an Espresso
        Coffee espresso = CoffeeFactory.createCoffee("Espresso");
        System.out.println("Name: " + espresso.getName());
        System.out.println("Description: " + espresso.getDescription());

        // Create a Cappuccino
        Coffee americano = CoffeeFactory.createCoffee("Americano");
        System.out.println("Name: " + americano.getName());
        System.out.println("Description: " + americano.getDescription());

        // Create a Latte
        Coffee latte = CoffeeFactory.createCoffee("Latte");
        System.out.println("Name: " + latte.getName());
        System.out.println("Description: " + latte.getDescription());
    }
}

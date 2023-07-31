package Factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        CoffeeFactory factory = new LatteCoffeeFactory();
        store.setFactory(factory);

        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}

package Factory.abstract_factory;

import Factory.factory_method.AmericanCoffeeFactory;

public class Client {
    public static void main(String[] args) {
        // Italy style
        AmericanDessertFactory factory = new AmericanDessertFactory();
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
    }
}

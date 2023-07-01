package chuwa.learn.factory;

import chuwa.learn.simpleFactory.SimpleCoffeeFactory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();
        return simpleCoffeeFactory.createCoffee(type);
    }
}

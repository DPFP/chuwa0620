package com.chuwa.learn.factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory sf = new SimpleCoffeeFactory();
        Coffee coffee = sf.createCoffee(type);
        coffee.addmilk();
        coffee.addsugar();
        return coffee;
    }
}

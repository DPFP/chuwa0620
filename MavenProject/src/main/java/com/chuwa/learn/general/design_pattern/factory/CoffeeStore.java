package com.chuwa.learn.general.design_pattern.factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {

//        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();

        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

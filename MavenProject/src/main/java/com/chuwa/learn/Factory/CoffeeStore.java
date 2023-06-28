package com.chuwa.learn.Factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        CoffeeFactory factory = new CoffeeFactory();
        Coffee coffee = factory.createCoffee(type);
        System.out.println(coffee.getName());
        coffee.addMilk();
        coffee.addSugar();
        return  coffee;
    }
}

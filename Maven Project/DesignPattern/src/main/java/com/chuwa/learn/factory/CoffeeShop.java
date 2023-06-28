package com.chuwa.learn.factory;

public class CoffeeShop {
    public Coffee orderCoffee(String type){
        CoffeeFactory factory = new CoffeeFactory();
        Coffee coffee = factory.createCoffee(type);
        return coffee;
    }
}

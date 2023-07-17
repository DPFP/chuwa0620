package com.chuwa.learn.designPattern.factory;

public class LatteCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}

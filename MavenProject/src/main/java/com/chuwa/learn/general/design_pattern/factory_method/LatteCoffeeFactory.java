package com.chuwa.learn.general.design_pattern.factory_method;

/**
 * create latte coffee factory
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}

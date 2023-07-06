package com.chuwa.learn.general.design_pattern.factory_method;

/**
 * American Coffee factory object, used to create american coffee
 */
public class AmericanCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}

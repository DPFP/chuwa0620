package com.chuwa.learn.general.design_pattern.factory;

/**
 * simple coffee factory
 */
public class SimpleCoffeeFactory {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;
        if ("american".equalsIgnoreCase(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equalsIgnoreCase(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("the coffee you order do not exist");
        }
        return coffee;
    }
}

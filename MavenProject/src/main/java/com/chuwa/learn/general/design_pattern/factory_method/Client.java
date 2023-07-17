package com.chuwa.learn.general.design_pattern.factory_method;

public class Client {

    public static void main(String[] args) {
        // create coffee store object
        CoffeeStore store = new CoffeeStore();
        CoffeeFactory factory = new AmericanCoffeeFactory();
        store.setFactory(factory);

        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getName());
    }
}

package com.chuwa.learn.designPattern.factory;

public class client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        AmericanCoffeeFactory americanCoffeeFactory = new AmericanCoffeeFactory();
        LatteCoffeeFactory latteCoffeeFactory = new LatteCoffeeFactory();
        coffeeStore.setFactory(americanCoffeeFactory);
        Coffee coffee1 = coffeeStore.orderCoffee();
        System.out.println(coffee1.getName());
        coffeeStore.setFactory(latteCoffeeFactory);
        Coffee coffee2 = coffeeStore.orderCoffee();
        System.out.println(coffee2.getName());
    }
}

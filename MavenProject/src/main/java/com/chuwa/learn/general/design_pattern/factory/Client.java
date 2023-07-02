package com.chuwa.learn.general.design_pattern.factory;

public class Client {

    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");

        System.out.println(coffee.getName());

    }
}

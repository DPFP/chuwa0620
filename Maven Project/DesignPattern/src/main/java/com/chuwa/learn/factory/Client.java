package com.chuwa.learn.factory;

public class Client {
    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();
        Coffee coffee1 = shop.orderCoffee("Americano");
        Coffee coffee2 = shop.orderCoffee("Latte");
        coffee1.addMilk();
        coffee2.addSugar();
        System.out.println(coffee1.getName());
    }
}

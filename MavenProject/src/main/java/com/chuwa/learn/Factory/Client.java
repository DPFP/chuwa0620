package com.chuwa.learn.Factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore shop = new CoffeeStore();
        Coffee coffee1 = shop.orderCoffee("Americano");
        Coffee coffee2 = shop.orderCoffee("Latte");
        coffee1.addMilk();
        coffee2.addSugar();
        System.out.println(coffee1.getName());
    }
}

package com.chuwa.learn.general.design_pattern.abstract_factory;

public class Client {

    public static void main(String[] args) {
        // Italy
        ItalyDessertFactory factory = new ItalyDessertFactory();
        // get Latte Coffee & Trimisu
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();

    }
}

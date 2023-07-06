package com.chuwa.learn.general.design_pattern.abstract_factory;

public interface DessertFactory {

    // produce coffee
    Coffee createCoffee();

    // produce dessert
    Dessert createDessert();
}

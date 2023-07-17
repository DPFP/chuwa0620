package com.chuwa.learn.general.design_pattern.factory_method;

import com.chuwa.learn.general.design_pattern.factory_method.Coffee;
import com.chuwa.learn.general.design_pattern.factory.SimpleCoffeeFactory;

public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    // order coffee
    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

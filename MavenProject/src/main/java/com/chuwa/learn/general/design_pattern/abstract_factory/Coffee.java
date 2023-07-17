package com.chuwa.learn.general.design_pattern.abstract_factory;

public abstract class Coffee {

    public abstract String getName();

    public void addSugar() {
        System.out.println("add sugar");
    }

    public void addMilk() {
        System.out.println("add milk");
    }
}

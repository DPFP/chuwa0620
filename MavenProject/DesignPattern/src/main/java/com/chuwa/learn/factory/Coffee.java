package com.chuwa.learn.factory;

public abstract class Coffee {
    public void addSugar(){
        System.out.println("Add Sugar!");
    }
    public void addMilk(){
        System.out.println("Add Milk!");
    }
    public abstract String getName();
}

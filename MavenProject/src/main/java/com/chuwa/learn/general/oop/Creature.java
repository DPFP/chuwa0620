package com.chuwa.learn.general.oop;

public interface Creature {

    void eat();

    default void say() {
        System.out.println("I belongs to creature!");
    }
}

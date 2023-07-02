package com.chuwa.learn.general.oop;

public abstract class Animal implements Creature {

    private String name;

    private Integer age;

    public Animal() {
        this.name = "";
        this.age = 0;
    }

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println(this.name + " is eating food!");
    }

    public abstract void makeSound();
}

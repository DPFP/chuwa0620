package com.chuwa.learn.general.oop;

import lombok.Data;

@Data
public class Dog extends Animal{

    // nunmber of times it saves the door
    private Integer saveDoorTimes;

    public Dog(String name, Integer age, Integer saveDoorTimes) {
        super(name, age);
        this.saveDoorTimes = saveDoorTimes;
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("dog eat bone");
    }

    @Override
    public void makeSound() {
        System.out.println("the dog said: wong wong!");
    }

    public void save() {
        System.out.println("The dog have save the door from bad guys " + saveDoorTimes + " times");
    }
}

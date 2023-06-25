package com.chuwa.learn.general.oop;

public class Test {

    public static void main(String[] args) {
        // encapsulation is all members name, age, and special thing
        // both dog and cat inherit Animal class
        // Polymorphism is show as below:
        Creature dog = new Dog("Husky", 10, 5);
        Creature cat = new Cat("Hello Kiki", 8, 2);

        dog.say();
        dog.eat();

        cat.eat();
        cat.say();

        // but here because dog and cat belongs to creature class, we cannot use methods not in there
        // so if we want to use special method, we need:
        Dog dog2 = new Dog("dog2", 11, 3);
        dog2.save();
    }
}

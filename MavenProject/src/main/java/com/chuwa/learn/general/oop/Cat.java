package com.chuwa.learn.general.oop;

import lombok.Data;

@Data
public class Cat extends Animal {

    // number of mouse it catch during it lifetime
    private Integer mouseCatchCount;

    @Override
    public void eat() {
        super.eat();
        System.out.println("cat eat fish");
    }

    public Cat(String name, Integer age, Integer mouseCatchCount) {
        super(name, age);
        this.mouseCatchCount = mouseCatchCount;
    }

    @Override
    public void makeSound() {
        System.out.println("the cat said: miao miao!");
    }

    public void catchMouse() {
        System.out.println("the cat has caught " + mouseCatchCount + " mouse");
    }

}

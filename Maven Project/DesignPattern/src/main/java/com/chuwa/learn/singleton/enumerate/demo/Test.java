package com.chuwa.learn.singleton.enumerate.demo;

public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance1 == instance2);
    }
}

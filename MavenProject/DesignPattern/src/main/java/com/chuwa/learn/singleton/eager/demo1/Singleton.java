package com.chuwa.learn.singleton.eager.demo1;

public class Singleton {
    private Singleton(){}

    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}

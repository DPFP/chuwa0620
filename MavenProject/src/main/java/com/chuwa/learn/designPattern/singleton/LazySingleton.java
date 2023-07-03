package com.chuwa.learn.designPattern.singleton;

public class LazySingleton {
    private LazySingleton(){};
    private static LazySingleton instance;
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

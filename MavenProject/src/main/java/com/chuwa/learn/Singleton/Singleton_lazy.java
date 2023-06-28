package com.chuwa.learn.Singleton;

public class Singleton_lazy {
    private Singleton_lazy(){}

    private static Singleton_lazy instance;

    public static synchronized Singleton_lazy getInstance(){
        if(instance == null){
            instance = new Singleton_lazy();
        }
        return instance;
    }
}

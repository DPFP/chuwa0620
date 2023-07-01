package com.chuwa.learn.Singleton;

public class Singleton_lazy2 {
    private Singleton_lazy2(){}

    private static volatile Singleton_lazy2 instance;

    public static Singleton_lazy2 getInstance(){
        if(instance == null){
            synchronized (Singleton_lazy2.class){
                if(instance == null){
                    instance = new Singleton_lazy2();
                }
            }
        }
        return instance;
    }
}

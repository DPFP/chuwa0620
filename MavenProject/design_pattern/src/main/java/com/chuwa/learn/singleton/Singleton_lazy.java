package com.chuwa.learn.singleton;

public class Singleton_lazy {
    private Singleton_lazy(){}
    private static class instance_holder{
        private static final Singleton_lazy instance = new Singleton_lazy();
    }

    public static Singleton_lazy getInstance(){
        return instance_holder.instance;
    }

    public static void main( String[] args )
    {
        Singleton_lazy instance = Singleton_lazy.getInstance();
        Singleton_lazy instance1 = Singleton_lazy.getInstance();
        System.out.println(instance == instance1);
    }
}

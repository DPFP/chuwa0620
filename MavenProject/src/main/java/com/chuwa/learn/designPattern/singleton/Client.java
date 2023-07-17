package com.chuwa.learn.designPattern.singleton;

public class Client {
    public static void main(String[] arg){
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println(instance2 == instance1);

        LazySingleton instance3 = LazySingleton.getInstance();
        LazySingleton instance4 = LazySingleton.getInstance();
        System.out.println(instance3 == instance4);
    }
}

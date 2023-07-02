package com.chuwa.learn.general.design_pattern.singleton;

public class SingletonLazy {

    private SingletonLazy() {}

//    private static SingletonLazy instance;
//
//    public static SingletonLazy getInstance() {
//        if (instance == null) {
//            synchronized (SingletonLazy.class) {
//                if (instance == null) {
//                    instance = new SingletonLazy();
//                }
//            }
//        }
//        return instance
//    }

    private static class SingletonHolder {
        private static final SingletonLazy INSTANCE = new SingletonLazy();
    }

    public static SingletonLazy getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

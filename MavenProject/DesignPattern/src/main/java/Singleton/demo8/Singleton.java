package Singleton.demo8;

import java.io.Serializable;

/*
 * lazy mode
 * inner static class
 * */
public class Singleton {
    private static boolean flag = false;

    private Singleton() {
        synchronized (Singleton.class){
            if(flag){
                throw new RuntimeException("Cannot create multiple object");
            }
            flag = true;
        }
    }

    // declare static inner class
    private static class SingletonHolder {
        // declare and initialization
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

package Singleton.demo7;

import java.io.Serializable;

/*
 * lazy mode
 * inner static class
 * */
public class Singleton implements Serializable {
    private Singleton() {
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

package Singleton.demo9;

import java.io.Serializable;

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

    // de-serialization, call this method, return this value
    public Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}

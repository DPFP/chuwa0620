package Singleton;

import java.io.Serializable;

public class Singleton implements Serializable {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public Object readResolve() {
        return getInstance();
    }
}

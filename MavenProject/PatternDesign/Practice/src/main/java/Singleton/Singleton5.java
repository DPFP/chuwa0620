package Singleton;

public class Singleton5 {

    private Singleton5() {

    }

    private static volatile Singleton5 instance;

    private static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

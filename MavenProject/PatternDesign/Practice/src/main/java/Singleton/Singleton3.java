package Singleton;

public class Singleton3 {
    private Singleton3() {

    }

    private static Singleton3 instance;

    static {
        instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

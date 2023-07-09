package Singleton;

public class Singleton4 {

    private Singleton4() {

    }

    private static Singleton4 instance;

    public static synchronized Singleton4 getInstance() {

        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

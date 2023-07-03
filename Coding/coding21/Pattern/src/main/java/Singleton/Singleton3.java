package Singleton;

public class Singleton3 {
    private Singleton3() {

    }

    private static Singleton3 instence;
    public static synchronized Singleton3 getInstence() {
        if (instence == null) {
            instence = new Singleton3();
        }
        return instence;
    }
}

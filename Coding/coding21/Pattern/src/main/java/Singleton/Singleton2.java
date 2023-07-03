package Singleton;

public class Singleton2 {
    private Singleton2() {

    }
    private static Singleton2 instence;
    static {
        instence = new Singleton2();
    }
    public static Singleton2 getInstence() {
        return instence;
    }
}

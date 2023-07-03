package Singleton;

public class Singleton4 {
    private Singleton4() {

    }
    private static Singleton4 instence;
    public static Singleton4 getInstence() {
        synchronized (Singleton4.class) {
            if (instence == null) {
                instence = new Singleton4();

            }
        }
        return instence;
    }
}

package Singleton;

public class Singleton6 {
    private Singleton6() {

    }

    private static class SingletonHoalder {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return SingletonHoalder.INSTANCE;
    }
}

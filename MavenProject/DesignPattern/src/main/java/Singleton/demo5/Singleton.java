package Singleton.demo5;

/*
* lazy mode
* inner static class
* */
public class Singleton {
    private Singleton(){}

    // declare static inner class
    private static class SingletonHolder {
        // declare and initialization
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

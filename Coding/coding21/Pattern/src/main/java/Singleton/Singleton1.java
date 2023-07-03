package Singleton;

public class Singleton1 {

    private Singleton1() {

    }
    private static Singleton1 instence = new Singleton1();
    public static Singleton1 getInstance(){
        return instence;
    }
}

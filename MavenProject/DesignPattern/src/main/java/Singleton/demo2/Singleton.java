package Singleton.demo2;
/*
* eager mode - static block
*
* */

public class Singleton {
    // private constructor
    private Singleton(){}

    // declare Singleton type variable
    private static Singleton instance; // null

    // static code block
    // not big diff compared to static variable
    static {
        instance = new Singleton();
    }

    public static Singleton getInstance(){
        return instance;
    }
}

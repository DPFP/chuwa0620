package Singleton.demo1;

/*
 * eager mode
 * static variable
 * */

public class Singleton {
    // 1. private constructor
    private Singleton(){}

    // 2. create this class object
    private static Singleton instance = new Singleton();

    // 3. provide common visit method
    public static Singleton getInstance(){
        return instance;
    }
}

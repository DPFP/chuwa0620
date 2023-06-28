package Singleton.demo3;
/*
* lazy mode - not thread safe
*
* */
public class Singleton {
    // private constructor
    private Singleton(){}

    // singleton instance
    private static Singleton instance; // not assign value

    // outside method
    public static synchronized Singleton getInstance(){
        if(instance == null){
            // thread 1 could wait here, and thread 2 could also enter the block
            // not singleton guarantee
            instance = new Singleton();
        }
        return instance;
    }
}

package singleton.eager1;

public class Singleton {
    //private constructor
    private Singleton(){}

    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}

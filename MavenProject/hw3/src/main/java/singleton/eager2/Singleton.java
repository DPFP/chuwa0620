package singleton.eager2;

public class Singleton {
    private Singleton(){}

    private static Singleton instance; //null

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance(){
        return instance;
    }
}

package singleton.lazy1And2;

public class Singleton {
    private Singleton() {}
    private static Singleton instance;

    public static synchronized Singleton getInstance() {  //thread safe: keyword: synchronized
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

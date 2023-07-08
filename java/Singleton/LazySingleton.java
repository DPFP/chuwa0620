package Singleton;

public class LazySingleton {
    private LazySingleton(){}
    private static LazySingleton lazy;

    public LazySingleton getLazySingleton(){
        if(lazy == null) lazy = new LazySingleton();
        return lazy;
    }
}

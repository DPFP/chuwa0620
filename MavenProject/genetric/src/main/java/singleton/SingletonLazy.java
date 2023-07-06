package singleton;

public class SingletonLazy {
    private SingletonLazy(){}
    private static SingletonLazy instance;
    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized (SingletonLazy.class) {
                instance = new SingletonLazy();
            }
        }
        return instance;
    }
}

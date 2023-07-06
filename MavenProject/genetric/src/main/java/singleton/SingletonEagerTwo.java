package singleton;

public class SingletonEagerTwo {
    private SingletonEagerTwo(){}
    private static SingletonEagerTwo instance;
    static {
        instance = new SingletonEagerTwo();
    }
    public static SingletonEagerTwo getInstance(){
        return instance;
    }
}

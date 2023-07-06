package singleton;

public class SingletonLazyTwo {
    private SingletonLazyTwo(){}
    private static class SingletonHolder {
        private static final SingletonLazyTwo INSTANCE = new SingletonLazyTwo();
    }
    public static SingletonLazyTwo getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

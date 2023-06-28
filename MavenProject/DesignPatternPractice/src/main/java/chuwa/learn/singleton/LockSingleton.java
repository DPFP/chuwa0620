package chuwa.learn.singleton;

public class LockSingleton {
    private LockSingleton(){}

    private static LockSingleton instance;

    public static LockSingleton getInstance(){
        if(instance==null){
            synchronized (LockSingleton.class){
                if(instance == null){
                    instance = new LockSingleton();
                }
            }
        }
        return instance;
    }
}

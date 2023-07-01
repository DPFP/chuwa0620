package chuwa.learn.singleton;

public class EagerSingleton {
    private EagerSingleton(){

    }

    private EagerSingleton instance = new EagerSingleton();

    public EagerSingleton getInstance() {
        return instance;
    }
}

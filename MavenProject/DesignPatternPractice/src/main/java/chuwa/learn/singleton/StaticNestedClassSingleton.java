package chuwa.learn.singleton;

public class StaticNestedClassSingleton {
    private StaticNestedClassSingleton(){}

    private static class SingletonHolder{
        private static final StaticNestedClassSingleton INSTANCE = new StaticNestedClassSingleton();
    }

    public static StaticNestedClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

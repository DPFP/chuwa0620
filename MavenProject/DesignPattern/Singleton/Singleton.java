package DesignPattern.Singleton;

public class Singleton {


}


class EagerSingleton{
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){}

    public static EagerSingleton getInstance() {
        return instance;
    }
}

class LazySingleton{
    private static LazySingleton instance;
    private LazySingleton(){};
    public static LazySingleton getInstance(){
        if(instance == null) instance = new LazySingleton();
        return instance;
    }
}

class OptimizedLazySingleton{
    // use volatile here to avoid the situation that instance might points to null
    //1. create instance reference
    //2. new singleton()
    //3. instance reference pints to instance object
    //jvm might do 1 3 2 here so instance could be null still
    private static volatile OptimizedLazySingleton instance;
    private OptimizedLazySingleton(){};

    public static OptimizedLazySingleton getInstance(){
        if(instance == null){
            //we use synchronized to lock the class here so that only one thread can access the code block at a time
            synchronized (OptimizedLazySingleton.class){
                //double check if the instance is null here bc we might have a T2 that initialize the instance already
                if (instance == null) instance = new OptimizedLazySingleton();
            }
        }
        return instance;
    }
}


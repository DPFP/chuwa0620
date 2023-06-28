package chuwa.learn.singleton;

public class LazySingleton {
    private LazySingleton(){}

    private static LazySingleton instance;

    public LazySingleton getLazySingleton(){
        if(this.instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

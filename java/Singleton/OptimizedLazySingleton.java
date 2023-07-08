package Singleton;

public class OptimizedLazySingleton {
    private static volatile OptimizedLazySingleton optimizedLazySingleton;
    private OptimizedLazySingleton(){};
    public OptimizedLazySingleton getOptimizedLazySingleton(){
        if(optimizedLazySingleton == null){
            synchronized (OptimizedLazySingleton.class){
                if (optimizedLazySingleton == null){
                    optimizedLazySingleton = new OptimizedLazySingleton();
                }
            }

        }
        return optimizedLazySingleton;
    }
}

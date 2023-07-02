package singleton.lazy3;
//double check lock
public class Singleton {
    private Singleton() {}

    private static volatile Singleton instance; // keywords: "volatile" deal with empty pointer error, keep visibility and order

    public static Singleton getInstance() {
        // First time check
        if (instance == null){
            // Second time check
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

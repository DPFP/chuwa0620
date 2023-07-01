package Singleton.demo2;

public class Client {
    public static void main(String[] args){
        // get singletonOne object
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // judge whether it is same object
        System.out.println(instance == instance2);
    }
}

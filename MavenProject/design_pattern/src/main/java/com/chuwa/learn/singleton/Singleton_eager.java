package com.chuwa.learn.singleton;

/**
 * Hello world!
 *
 */
public class Singleton_eager
{
    private Singleton_eager() {}
    private static Singleton_eager instance = new Singleton_eager();
    public static Singleton_eager getInstance() {
        return instance;
    }
    public static void main( String[] args )
    {
        Singleton_eager instance = Singleton_eager.getInstance();
        Singleton_eager instance1 = Singleton_eager.getInstance();
        System.out.println(instance == instance1);
    }
}

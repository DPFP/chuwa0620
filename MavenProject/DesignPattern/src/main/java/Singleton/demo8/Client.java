package Singleton.demo8;

import java.lang.reflect.Constructor;

public class Client {
    public static void main(String[] args) throws Exception {
        // get singleton instance byte code
        Class clazz = Singleton.class;
        // get non-parameter constructor
        Constructor cons = clazz.getDeclaredConstructor();
        // cancel visit check
        cons.setAccessible(true);
        // create object
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();
        System.out.println(s1 == s2);
    }
}
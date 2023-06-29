package com.chuwa.learn.singleton.lazy.demo3;

import com.chuwa.learn.singleton.lazy.demo1.Singleton;

public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}

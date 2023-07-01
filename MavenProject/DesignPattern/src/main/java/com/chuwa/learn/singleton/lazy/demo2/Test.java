package com.chuwa.learn.singleton.lazy.demo2;

import com.chuwa.learn.singleton.lazy.demo1.Singleton;

public class Test {
    public static void main(String[] args) {
        com.chuwa.learn.singleton.lazy.demo1.Singleton instance1 = com.chuwa.learn.singleton.lazy.demo1.Singleton.getInstance();
        com.chuwa.learn.singleton.lazy.demo1.Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}

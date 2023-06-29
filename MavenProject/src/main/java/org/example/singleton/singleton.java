package org.example.singleton;

public class singleton {
    //私有构造方法
    private singleton() {}

    private static volatile singleton instance;

    //对外提供静态方法获取该对象
    public static singleton getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实际
        if(instance == null) {
            synchronized (singleton.class) {
                //抢到锁之后再次判断是否为空
                if(instance == null) {
                    instance = new singleton();
                }
            }
        }
        return instance;
    }
}
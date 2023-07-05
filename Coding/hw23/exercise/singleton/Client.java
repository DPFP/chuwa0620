package exercise.singleton;

import com.chuwa.learn.general.design_pattern.singleton.SingletonEnum;

public class Client {

    public static void main(String[] args) {

        SingletonEager instance = SingletonEager.getInstance();
        SingletonEager instance2 = SingletonEager.getInstance();

        System.out.println(instance == instance2);

        SingletonLazy instance3 = SingletonLazy.getInstance();
        SingletonLazy instance4 = SingletonLazy.getInstance();

        System.out.println(instance3 == instance4);

        System.out.println(SingletonEnum.INSTANCE == SingletonEnum.INSTANCE);;
    }
}

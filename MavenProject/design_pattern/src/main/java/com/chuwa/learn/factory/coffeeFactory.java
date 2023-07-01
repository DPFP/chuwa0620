package com.chuwa.learn.factory;

public class coffeeFactory {
    public static Coffee createCoffee(String type) {
        //声明Coffee类型的变量，根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡没有");
        }

        return coffee;
    }
}

abstract class Coffee {
    public abstract String getName();
    public void addsugar() {
        System.out.println("加糖");
    }
    public void addMilk() {
        System.out.println("加奶");
    }
}

class AmericanCoffee extends Coffee {
    public String getName() {
        return "美式咖啡";
    }
}

class LatteCoffee extends Coffee {

    public String getName() {
        return "拿铁咖啡";
    }
}

class CoffeeStore {
    public Coffee orderCoffee(String type) {

        /*SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);*/
        Coffee coffee = coffeeFactory.createCoffee(type);

        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
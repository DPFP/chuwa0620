package chuwa.learn;

public class Main {
    public static void main(String[] args) {
        Coffee coffee1 = CoffeeFactory.createCoffee("American coffee");
        Coffee coffee2 = CoffeeFactory.createCoffee("Latte");
    }
}
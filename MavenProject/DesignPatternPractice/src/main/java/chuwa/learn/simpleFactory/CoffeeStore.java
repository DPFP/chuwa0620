package chuwa.learn.simpleFactory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();
        return simpleCoffeeFactory.createCoffee(type);
    }
}

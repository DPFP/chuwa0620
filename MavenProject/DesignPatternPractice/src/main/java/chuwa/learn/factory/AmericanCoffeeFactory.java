package chuwa.learn.factory;

public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        Coffee coffee = new AmericanCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

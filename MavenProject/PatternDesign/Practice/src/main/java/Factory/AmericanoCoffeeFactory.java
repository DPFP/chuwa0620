package Factory;

public class AmericanoCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        Coffee coffee = new AmericanoCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

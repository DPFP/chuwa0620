package Factory.static_factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}

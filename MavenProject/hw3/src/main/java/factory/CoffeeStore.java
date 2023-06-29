package factory;

public class CoffeeStore {
    private CoffeeFactory factory;

    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    // avoid了前面提到的在constructor里进行CoffeeStore和CoffeeFactory object的coupling: this.factory = new CoffeeFactory()
    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    // 点咖啡
    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();

        // 加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

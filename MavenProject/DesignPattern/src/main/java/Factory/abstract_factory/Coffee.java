package Factory.abstract_factory;

public abstract class Coffee {
    public abstract String getName();

    // add sugar
    public void addSugar() {
        System.out.println("Add Sugar");
    }

    // add milk
    public void addMilk() {
        System.out.println("Add Milk");
    }
}

package DesignPattern.Decorator;
//input stream is a good example of decorator
public abstract class Beverage {
    public abstract double cost();
}

class MilkTea extends Beverage{
    public double cost(){
        System.out.println("MilkTea cost : 5.5");
        return 5.5;
    }
}

class FruitTea extends Beverage{
    public double cost(){
        System.out.println("FruitTea cost : 5.6");
        return 5.6;
    }
}
class Yogurt extends Beverage{
    public double cost(){
        System.out.println("Yogurt cost : 5.0");
        return 5.0;
    }
}

abstract class ToppingDecorator extends Beverage{

}

class Pudding extends ToppingDecorator{
    private static final int COST = 1;
    private final Beverage beverage;
    public Pudding(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        System.out.println("Adding pudding cost : 1");
        return this.beverage.cost() + COST;
    }
}

class Boba extends ToppingDecorator{
    private static final double COST = 1.5;
    private final Beverage beverage;
    public Boba(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        System.out.println("Adding Boba cost : 1.5");
        return this.beverage.cost() + COST;
    }
}

class test{
    public static void main(String[] args) {
        Beverage milkTea = new MilkTea();
        milkTea = new Boba(milkTea);
        milkTea = new Boba(milkTea);
        System.out.println(milkTea.cost());
    }
}
package Factory.static_factory;
/*
* simple factory
*
* */

public class SimpleCoffeeFactory {
    public static Coffee createCoffee(String type){
        Coffee coffee = null;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)){
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("no selected coffee provided");
        }
        return coffee;
    }
}

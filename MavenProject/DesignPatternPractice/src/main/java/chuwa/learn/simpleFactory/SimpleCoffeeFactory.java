package chuwa.learn.simpleFactory;

public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if(type.equals("American coffee")){
            coffee = new AmericanCoffee();
        }
        else if(type.equals("Latte")){
            coffee = new LatteCoffee();
        }
        else{
            throw  new RuntimeException("No such coffee");
        }
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

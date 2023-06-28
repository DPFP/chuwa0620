package com.chuwa.learn.factory;

import java.util.Optional;

public class CoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if(type == "Americano"){
            coffee = new Americano();
        } else if (type == "Latte") {
            coffee = new Latte();
        } else throw new RuntimeException("No such coffe type!");
        Optional<Coffee> coffeeOptional = Optional.of(coffee);
        return coffee;
    }
}

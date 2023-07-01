package com.chuwa.learn.Factory;

import java.util.Optional;

public class CoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if(type == "Americano"){
            coffee = new Americano();
        } else if (type == "Latte") {
            coffee = new Latte();
        } else {
            throw new RuntimeException("Please provide valid coffee type");
        }
        return coffee;
    }
}

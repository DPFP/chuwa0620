package com.chuwa.learn.exercise;

public class Customer {
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    private ShoppingCart shoppingCart;
    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }
}

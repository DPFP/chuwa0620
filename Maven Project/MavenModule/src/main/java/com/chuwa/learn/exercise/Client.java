package com.chuwa.learn.exercise;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class Client {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        Item pear = new Item();
        Item watermelon = new Item();
        pear.setName("pear");
        pear.setPrice(5.0);
        watermelon.setName("watermelon");
        watermelon.setPrice(10.0);
        List<Item> cart = asList(pear, watermelon);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItems(cart);
        customer1.setShoppingCart(shoppingCart);

        // getFirstItemName
        Optional<String> firstItemName1 = ShoppingCartUtil.getFirstItemName(customer1);
        Optional<String> firstItemName2 = ShoppingCartUtil.getFirstItemName(customer2);
        if(firstItemName1.isPresent()){
            System.out.println(firstItemName1.get());
        } else System.out.println("Item not exists.");
        if(firstItemName2.isPresent()){
            System.out.println(firstItemName2.get());
        } else System.out.println("Item not exists.");

        // getTotalPrice
        Optional<Customer> customer = Optional.of(customer1);
        System.out.println("Total price: " + ShoppingCartUtil.getTotalPrice(customer));

        // getFirstItemNameWithAlternative
        System.out.println("Customer 2 has default item: " + ShoppingCartUtil.getRandomAlternativeItem());

        // checkItemsInCart
        ShoppingCartUtil.checkItemsInCart(customer1);
        ShoppingCartUtil.checkItemsInCart(customer2);

        // printItemsInCart
        ShoppingCartUtil.printItemsInCart(customer1);
        ShoppingCartUtil.printItemsInCart(customer2);

        // getFirstItemNameOrThrowException
        System.out.println("Customer 1 has: " + ShoppingCartUtil.getFirstItemNameOrThrowException(customer1));
        System.out.println("Customer 2 has: " + ShoppingCartUtil.getFirstItemNameOrThrowException(customer2));
    }
}

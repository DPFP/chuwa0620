package exercise.optional;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Customer customer = new Customer();
        ShoppingCart shoppingCart = new ShoppingCart();

        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item("item1", 1.2);
        Item item2 = new Item("item2", 2.4);
//        itemList.add(null);
        itemList.add(item1);
        itemList.add(item2);
        shoppingCart.setItems(itemList);
        customer.setShoppingCart(shoppingCart);

        ShoppingCartUtil.printItemsInCart(customer);
        System.out.println();

        System.out.println(ShoppingCartUtil.getFirstItemNameOrThrowException(customer));
    }
}

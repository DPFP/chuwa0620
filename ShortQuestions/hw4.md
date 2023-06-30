# 1. What is generic in Java?  and type the generic code by yourself
"generic" refers to a feature that allows the creation of classes, interfaces, and methods that can work with different data types.

# 2.  Read those codes and type it one by one by yourself. the push the code to your branch
See details in folder Coding 

# 3. Practice stream API 
> Exercise 1 - Obtain a list of products belongs to category "Books" with price > 100

```
List<Product> list = productRepo
    .findAll()
    .stream()
    .filter(p->p.category.equals("Books"))
    .filter(p->p.price > 100)
    .collect(Collectors.toList());
```

> Exercise 3 - Obtain a list of product with category = "Toys" and then apply 10% discount

```
List<Product> list = productRepo
    .stream()
    .filter(p->p.category.equals("Toys"))
    .map(p->p.price = p.price * 0.9)
    .collect(Collectors.toList());
```

> Exercise 5 - Get the cheapest products of "Books" category
```
Optional<Product> result = productRepo
    .stream()
    .filter(p->p.getCategory().equals("Books"))
    .min(Comparator.comparing(Product::getPrice));
```

> Exercise 7 - Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
```
List<Product> result = orderRepo.findAll()
    .stream()
    .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
    .peek(o -> System.out.println(o.toString()))
    .flatMap(o -> o.getProducts().stream())
    .distinct()
    .collect(Collectors.toList());
```

# 4. Practice Optional methods 
```
/**
     * 编写一个方法，接受一个Customer对象作为参数，返回一个包含购物车中第一个商品名称的Optional<String>对象。
     * 如果客户或购物车信息缺失，或购物车为空，则返回一个空的Optional对象。
     */
    public static Optional<String> getFirstItemName(Customer customer) {
        return Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> items != null && items.length > 0)
                .map(items -> items[0])
                .map(Optional::ofNullable)
                .orElse(Optional.empty());
    }

    /**
     * 编写一个方法，接受一个Optional<Customer>对象作为参数。如果Optional对象非空且包含的客户有购物车，计算购物车中所有商品的总价，并返回该值。如果购物车为空或不存在，返回默认值0.0。
     * @param customer
     * @return
     */
    public static double getTotalPrice(Optional<Customer> customer) {
        return customer.flatMap(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .flatMap(items -> {
                    if (items.length > 0) {
                        return Optional.of(items);
                    } else {
                        return Optional.empty();
                    }
                })
                .map(items -> {
                    double totalPrice = 0.0;
                    for (Item item : items) {
                        totalPrice += item.getPrice();
                    }
                    return totalPrice;
                })
                .orElse(0.0);
    }

    /**
     * 假设我们想要检查客户购物车中是否有商品，并打印相应的消息。
     *
     * 编写一个方法，接受一个Customer对象作为参数，然后使用isPresent()检查购物车中是否有商品，并打印相应的消息：
     *
     * 我们使用了isPresent()方法来检查Optional对象是否非空。我们首先从Customer对象中获取购物车商品列表，然后检查其是否为空。
     * 如果Optional对象非空且商品列表非空，我们打印“购物车中有商品”；否则，我们打印“购物车为空”。
     */
    public static void checkItemsInCart(Customer customer) {
        Optional<ShoppingCart> optionalCart = Optional.ofNullable(customer.getShoppingCart());
        if (optionalCart.isPresent() && !optionalCart.get().getItems().isEmpty()) {
            System.out.println("购物车中有商品");
        } else {
            System.out.println("购物车为空");
        }
    }
```

# 5. Write the Singleton design pattern include eager load and lazy load.
```
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}
```
```
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

```

# 6.  What is Runtime Exception? could you give me some examples?
Runtime Exception, also called unchecked exception occur during the execution of a program and are typically caused by issues that could not be anticipated or recovered from at compile-time.

Examples are NullPointerException and ArrayIndexOutOfBoundsException

# 7. Could you give me one example of NullPointerException?
```
User user = null;
String name = user.name;
```

# 8.  What is the Optional class?
The Optional class is a container class designed to represent the presence or absence of a value.

# 9.  What are the advantages of using the Optional class?
It is primarily used to avoid null pointer exceptions and provide a more expressive and concise way of dealing with potentially null values.

# 10. What is the @FunctionalInterface?
Interfaces with exactly one abstract method signature. 

# 11. What is lamda?
 Lamda expressions provide a concise way to represent a block of code as a function and enable functional programming capabilities in Java. It's in such syntax:
 (parameters) -> { body }  
       
# 12. What is Method Reference?
Method reference is a feature introduced in Java 8 that provides a concise way to refer to methods or constructors as lambdas. It allows you to pass a method as an argument or assign it to a functional interface without explicitly writing a lambda expression. Its syntax is like:Class::method    

# 13. What is Java 8 new features?
- Stream
- Optional
- FunctionalInterface
- Lamda expression
- Method reference

# 14. Lambda can use unchanged variable outside of lambda? what is the details?
Yes, it can, but only when the variables' values are not changed through their whole lifetime.

# 15. Describe the newly added features in Java 8?
See details in answer to Q13.

# 16. Can a functional interface extend/inherit another interface?
Yes, it can. The child interface will still be considered a functional interface as long as it meets the criteria of having exactly one abstract method.

# 17. How does a lambda expression relate to a functional interface?
A lambda expression provides a concise way to create an instance of a functional interface. When you write a lambda expression, you are essentially providing an implementation for the abstract method of a functional interface. The lambda expression acts as a syntactic sugar for implementing the single abstract method of the functional interface.

# 18. What is Method Reference?
Method reference is a feature introduced in Java 8 that provides a concise way to refer to methods or constructors as lambdas. It allows you to pass a method as an argument or assign it to a functional interface without explicitly writing a lambda expression. Its syntax is like:Class::method 

# 19. What does the String::ValueOf expression mean?
The function 'String.valueOf()' is now a parameter that is to be used for certain input, and will create certain output.

# 20. What are Intermediate and Terminal operations?
- Intermediate: filter, map, flatMap, distinct, sorted, limit, and skip
- Terminal: forEach, collect, reduce, count, anyMatch, allMatch, noneMatch, and findFirst

# 21. What are the most commonly used Intermediate operations?
filter

# 22. What is the difference between findFirst() and findAny()?
The findFirst() method returns the first element in the stream, based on the encounter order.

The findAny() method returns any element from the stream. It does not guarantee any specific order or predictability in which element it returns.

# 23. How are Collections different from Stream?
 Collections contains different type of data structures, while Stream is a data flow.

 Collections are typically available for modifying contents, but Stream does not change its source data.
  
   
    
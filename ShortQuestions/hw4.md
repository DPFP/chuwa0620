## 1. What is generic in Java? and type the generic code by yourself.

In Java, generics provide a way to create parameterized types, allowing classes, interfaces, and methods to operate on
different types while providing compile-time type safety.

```java
public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
```

```java
Box<Integer> integerBox=new Box<>();
        integerBox.setItem(42);
        int intValue=integerBox.getItem();

        Box<String> stringBox=new Box<>();
        stringBox.setItem("Hello, World!");
        String stringValue=stringBox.getItem();
```

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.

Done

## 3. practice stream API at least 3 times.

Done.

## 4. Practice Optional methods at least 2 times.

Done.

## 5. Write the Singleton design pattern include eager load and lazy load.

```java
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static getInstance() {
        return instance;
    }
}
```

```java
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

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

## 6. What is Runtime Exception? could you give me some examples?

A runtime exception, also known as an uncaught exception or an unchecked exception, is an exception that occurs during
the execution of a program. Unlike checked exceptions, which are enforced to be caught or declared in the method
signature, runtime exceptions do not need to be explicitly handled.

ere are some examples of runtime exceptions:

NullPointerException: This occurs when you try to access or invoke a method on a null object reference.

ArrayIndexOutOfBoundsException: It is thrown when you try to access an array element using an index that is outside the
valid range of the array.

ArithmeticException: This exception occurs when an arithmetic operation, such as division or modulo, is attempted with
inappropriate operands. For example, dividing a number by zero would result in an ArithmeticException.

ClassCastException: This exception is thrown when an attempt is made to cast an object to a type that it is not
compatible with.

IllegalArgumentException: This exception is thrown when a method receives an argument of an invalid or inappropriate
value.

UnsupportedOperationException: This exception is thrown when an unsupported operation is called on an object. For
example, trying to modify an unmodifiable collection would result in this exception.

## 7. Could you give me one example of NullPointerException?

```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String text = null;
        int length = text.length(); // NullPointerException: 'text' is null
        System.out.println("Length: " + length);
    }
}

```

## 8. What is the Optional class?

The Optional class is a container class introduced in Java 8 as part of the Java.util package. It is designed to provide
a more expressive and type-safe way of representing nullable values. The purpose of Optional is to explicitly indicate
the presence or absence of a value and to avoid the pitfalls of null references.

## 9. What are the advantages of using the Optional class?

* Avoiding NullPointerExceptions
* Expressing the presence or absence of a value
* Encouraging explicit handling
* Enforcing a functional programming style
* Avoiding defensive null checks
* Better API design

## 10. What is the @FunctionalInterface?

A functional interface is an interface that has exactly one abstract method. It serves as a contract for functional
programming in Java, where functions can be treated as first-class citizens. The single abstract method represents the
behavior of the function, making it possible to use lambda expressions or method references to express the behavior
concisely.

## 11. what is lamda?

A lambda expression, also known as a lambda function or anonymous function, is a concise way to represent a piece of
code that can be treated as a method argument, passed around, or stored in a variable. Lambda expressions were
introduced in Java 8 to support functional programming concepts.

## 12. What is Method Reference?

A method reference is a shorthand notation in Java that allows you to refer to an existing method by its name instead of
providing a lambda expression or an anonymous inner class to define the behavior. It is a way to pass a method as a
value or expression.

## 13. What is Java 8 new features?

forEach() method in Iterable interface

default and static methods in Interfaces

Functional Interfaces and Lambda Expressions

Java Stream API for Bulk Data Operations on Collections

Java Time API

Collection API improvements

Concurrency API improvements

Java IO improvements

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

In summary, lambda expressions can access effectively final variables from their enclosing scope. Non-final variables
are not allowed to be accessed from lambdas, unless they are mutable references

## 15. Describe the newly added features in Java 8?

Lambda Expressions: Lambda expressions provide a concise way to represent functional interfaces. They allow you to write
more expressive code by treating functions as first-class citizens. Lambdas enable a more functional programming style
in Java.

Stream API: The Stream API provides a powerful and declarative way to process collections of data. It allows you to
perform operations such as filtering, mapping, and reducing on streams of elements, enabling efficient and parallel
processing.

Default Methods: Default methods allow interfaces to provide a default implementation for methods. This feature enables
backward compatibility by allowing interfaces to evolve without breaking existing implementations.

Optional: The Optional class provides a container object to represent the presence or absence of a value. It encourages
explicit handling of null values and helps prevent NullPointerExceptions.

Functional Interfaces: Java 8 introduced a set of new functional interfaces in the java.util.function package, such as
Predicate, Function, Consumer, and Supplier. These interfaces facilitate the use of lambda expressions and provide a
foundation for functional programming in Java.

Method References: Method references allow you to refer to existing methods by their names, providing a concise way to
pass behavior as a value. They simplify the syntax when the behavior corresponds to an existing method.

Date and Time API: Java 8 introduced the new Date and Time API in the java.time package. It provides a more
comprehensive and flexible way to handle date and time-related operations, addressing the limitations and complexities
of the older java.util.Date and java.util.Calendar classes.

Parallel and Asynchronous Programming: Java 8 introduced CompletableFuture and enhancements to the java.util.concurrent
package to support parallel and asynchronous programming. These features enable more efficient and scalable concurrent
programming in Java.

Nashorn JavaScript Engine: Java 8 included the Nashorn JavaScript engine, which allows you to embed and execute
JavaScript code within Java applications. It provides interoperability between Java and JavaScript, allowing developers
to leverage JavaScript capabilities.

Compact Profiles: Java 8 introduced compact profiles, which are subsets of the Java SE platform targeted at specific
deployment scenarios with limited resource environments. These profiles allow for more efficient and compact Java
runtime environments.

## 16. Can a functional interface extend/inherit another interface?

Yes, a functional interface can extend or inherit another interface. In Java, an interface can extend another interface
using the extends keyword, and this extends relationship can be applied to functional interfaces as well.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

A lambda expression in Java is a concise way to represent a block of code as a method argument or as an assignment to a
functional interface. It allows you to define behavior inline without the need for writing traditional anonymous inner
classes or explicit method implementations.

Lambda expressions are closely related to functional interfaces in Java. A functional interface is an interface that has
exactly one abstract method, known as the functional method. Lambda expressions are used to provide a concise
implementation of this functional method.

By using a lambda expression, you can provide the implementation of the functional method directly at the point of use,
without the need to explicitly create a separate class or implement the interface using anonymous inner classes.

## 18. In Java 8, what is Method Reference?

In Java 8, method reference is a feature that allows you to refer to an existing method by its name instead of providing
a lambda expression or an anonymous inner class to define the behavior. It provides a concise and readable way to pass
behavior as a value or expression.

## 19. What does the String::ValueOf expression mean?

String::valueOf is a method reference that allows you to refer to the static valueOf method of the String class. It
represents the behavior of converting different types of values into strings and can be used as a functional interface
to perform such conversions.

## 20. What are Intermediate and Terminal operations?

Intermediate operations:  filter(), map(), distinct(), sorted(), limit(), and flatMap().

Terminal operations: collect(), forEach(), count(), min(), max(), reduce(), and anyMatch().

## 21. What are the most commonly used Intermediate operations?

filter, map

## 22. What is the difference between findFirst() and findAny()?

findFirst() will return the first element based on that order.

The findAny() method returns any element from the stream, not necessarily the first element. It may provide better
performance when used with parallel streams, as it can choose any available element without considering the encounter
order. If the stream is empty, findAny() will return an empty Optional.

## 23. How are Collections different from Stream?

collections are data structures that store elements in memory and provide direct access and modification capabilities.
Streams, on the other hand, represent a sequence of elements flowing through a pipeline of operations, offering lazily
evaluated transformations and computations without storing the elements themselves. Streams are designed to support
functional programming paradigms and efficient processing of data.





## Q1 What is generic in Java?  and type the generic code by yourself.
Generics enable you to create reusable code that can operate on different types while providing compile-time type checking, ensuring type safety and code reusability.

## Q5 Write the Singleton design pattern include eager load and lazy load.
```java
class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){}
    public EagerSingleton getInstance() {
        return instance;
    }
}
class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}
    public LazySingleton getInstance() {
        if (instance == null)instance = new LazySingleton();
        return instance;
    }
}
```

## Q6 What is Runtime Exception? could you give me some examples?
They are exceptions occur during the runtime, including ArrayIndexOutOfBoundsException, NullPointerException, ArithmeticException.

## Q7 Could you give me one example of NullPointerException?

```java
String name = null;
int length = name.length();
```

## Q8 What is the Optional class?
Optional class is a container class introduced in Java 8 that is used to eliminate the need for explicit null checks, reducing the likelihood of encountering NullPointerExceptions.

## Q9 What are the advantages of using the Optional class?
It can eliminate the need for explicit null checks, reducing the likelihood of encountering NullPointerExceptions.

## Q10 What is the @FunctionalInterface?
It is used to indicate that an interface is intended to be a functional interface. A functional interface is an interface that contains exactly one abstract method and is used as the basis for lambda expressions or method references.

## Q11 what is lamda?
Lambda is a concise and anonymous function in Java that allows you to express and pass behavior as a parameter to methods or assign it to variables.

## Q12 What is Method Reference?
Method Reference is a shorthand syntax in Java that allows you to refer to a method by its name instead of invoking it directly, providing a more concise way to express certain lambda expressions.

## Q13 What is Java 8 new features?
Lambda expressions, Stream API, Default methods, Methods references, Optional.

## Q14 Lambda can use unchanged variable outside of lambda? what is the details?
Yes, it can. The rule is: 
it can use variables from their surrounding scope as long as those variables are effectively final, meaning their values do not change after initialization.

## Q15 Describe the newly added features in Java 8?
Lambda Expressions: Enables functional-style programming by providing a concise syntax to represent anonymous functions.

Stream API: Facilitates efficient processing of collections using functional-style operations like filtering, mapping, and reducing.

Default Methods: Allows adding new methods to interfaces without breaking existing implementations.

Optional: Provides a type-safe wrapper for nullable values, avoiding null pointer exceptions.

Method References: Offers a concise way to refer to methods using predefined or custom functional interfaces.

## Q16 Can a functional interface extend/inherit another interface?
Yes, but there are some rules to follow:
1.The interface being extended must also be a functional interface, it should contain only one abstract method.
2.The functional interface can inherit default methods from the parent interface, and those methods do not affect the functional nature of the interface.
3.If the parent interface contains abstract methods in addition to the single abstract method of the functional interface, those methods are inherited but do not contribute to the single abstract method of the functional interface.

## Q17 What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
Lambda Expressions enables functional-style programming by providing a concise syntax to represent anonymous functions.

## Q18 In Java 8, what is Method Reference?
Method References offers a concise way to refer to methods using predefined or custom functional interfaces.

## Q19 What does the String::ValueOf expression mean?
It is a method reference that refers to the valueOf method of the String class.


## Q20 What are Intermediate and Terminal operations?
Intermediate operations in Java Streams are operations that transform the stream or produce a new stream, allowing further operations to be applied, while terminal operations are operations that produce a result or a side effect, causing the stream to be consumed and no further operations to be applied.

## Q21 What are the most commonly used Intermediate operations?
filter, map, flatMap, distinct, sorted and limit

## Q22 What is the difference between findFirst() and findAny()?
findFirst() returns the first element of a stream, while findAny() returns any element of a stream.

## Q23 How are Collections different from Stream?
Collections in Java represent a group of objects that can be stored and accessed, while Streams provide a functional-style approach for processing data in a sequence-like manner without storing the entire data set.
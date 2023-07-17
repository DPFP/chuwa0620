# HW4
**1. What is generic in Java?**
Generic refers to a feature that allows you to define classes, interfaces, and methods that can work with different data types while maintaining type safety. 

**5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?**
eager:
```
public class Singleton
{
    private Singleton() {}
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}
```

lazy:
```
public class Singleton {
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
```

**6. What is Runtime Exception? could you give me some examples?**
A runtime exception is an error that occurs during the execution of a program at runtime. It typically indicates a problem that prevents the normal execution of the program and is usually caused by logic errors, input validation failures, or unexpected conditions.

Unlike checked exceptions, runtime exceptions do not need to be explicitly declared or caught by the programmer. They are usually unchecked by the compiler, which means that they can occur without prior indication in the code.

Here are a few examples of runtime exceptions:
- NullPointerException
- ArrayIndexOutOfBoundsException
- ArithmeticException
- ClassCastException
- IllegalArgumentException

**7. Could you give me one example of NullPointerException?**
```
String name = null;
int length = name.length();  // This will throw a NullPointerException
```

**8. What is the Optional class？**
The Optional class is a class introduced in Java 8 as part of the Java.util package. It is used to represent an optional value, which means a value that may or may not be present. It helps to handle situations where a value may be absent and avoids the need for null checks. The Optional class provides methods for querying the presence of a value, accessing the value if it is present, and performing operations on the value. Here are some key features of the Optional class:

**9. What are the advantages of using the Optional class?**
The Optional class promotes better code readability by explicitly expressing the possibility of an absent value. It encourages the use of methods like orElse(), ifPresent(), and chaining operations instead of direct null checks, which can help avoid NullPointerExceptions and make the code more robust.

**10. What is the @FunctionalInterface?**
A functional interface is an interface that contains only one abstract method, often referred to as a functional method.

**11. what is lamda?**
Lambda expressions enable functional programming in Java. Lambda expressions allows you to write more concise and expressive code when dealing with functional interfaces. It provides a way to create anonymous functions, essentially allowing you to pass behavior as an argument to a method or to assign behavior to a variable. This is particularly useful for writing more readable and compact code when working with interfaces like Runnable, Callable, ActionListener, and others.

**12. What is Method Reference?**
A method reference is a concise way to refer to a method or a constructor of a class. It provides a way to pass a method or constructor as a reference to a functional interface.

**13. What are Java 8 new features?**
Some of the key features of Java 8 are:
- Lambda Expressions
- Stream API
- Default Methods
- Optional
- Method References
- Functional Interfaces:
- Parallel and Asynchronous Programming

**14. Lambda can use unchanged variable outside of lambda? what is the details?**
If a lambda expression uses a variable from its enclosing scope, that variable must be effectively final or final. This means that you cannot modify the value of the variable inside the lambda expression once it has been assigned.

**15. Describe the newly added features in Java 8?**
- Lambda Expressions: Lambda expressions enable functional programming in Java. 
- Stream API: The Stream API provides a new way to process collections of data in a functional programming style. 
- Default Methods: Default methods allow you to add methods to interfaces without breaking the existing implementations of those interfaces. They enable the evolution of interfaces by providing default implementations for methods.
- Optional: The Optional class is a container object that may or may not contain a non-null value. It helps to handle null values more effectively and avoid null pointer exceptions.
- Method References: Method references provide a way to refer to methods without invoking them. They can be used to make the code more readable and concise.
- Functional Interfaces: Functional interfaces have a single abstract method and can be used as the basis for lambda expressions and method references.
- Parallel and Asynchronous Programming: Java 8 introduced new features to facilitate parallel and asynchronous programming. The Stream API supports parallel processing of data, and CompletableFuture class provides a convenient way to write asynchronous and non-blocking code.

**16. Can a functional interface extend/inherit another interface?**
An interface that extends another interface can be a functional interface if it satisfies the requirements of a functional interface. In other words, if the extended interface has only one abstract method and the sub-interface doesn't introduce any additional abstract methods, then the sub-interface can be used as a functional interface.
```
@FunctionalInterface
interface ParentInterface {
    void parentMethod();
}

@FunctionalInterface
interface ChildInterface extends ParentInterface {
    // void childMethod(); ChildInterface canot introduce abstract method in order to be a functional interface
}
```

**17.  What is the lambda expression in Java and How does a lambda expression relate to a functional interface??**
In Java, a lambda expression is a concise way to represent a functional interface, which is an interface with a single abstract method. It provides a way to write more compact and readable code when working with functional interfaces.

Lambda expressions in Java can be used to provide a concise implementation of the abstract method of a functional interface.

**18. In Java 8, what is Method Reference?**
A method reference is a concise way to refer to a method or a constructor of a class. It provides a way to pass a method or constructor as a reference to a functional interface.

**19. What does the String::ValueOf expression mean?**
Method reference of ValueOf method in String class.

**20. What are Intermediate and Terminal operations?**

**21. What are the most commonly used Intermediate operations?**

**22. What is the difference between findFirst() and findAny()?**
The findFirst() method returns the first element of the stream, if any, in the encounter order of the stream. The encounter order refers to the order in which the elements were initially present in the stream. If the stream is empty, findFirst() will return an empty Optional.

On the other hand, the findAny() method returns an arbitrary element of the stream, if any. It does not guarantee any particular order of the elements. 

**23. How are Collections different from Stream?**
Collections are data structures used for storing and manipulating groups of objects, while streams are a higher-level abstraction for processing and transforming data in a functional and declarative manner. Collections focus on storing and accessing data, while streams focus on transforming and processing data in a pipeline of operations.
# HW 3
## Q1.  What is generic in Java?  and type the generic code by yourself.
```
Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types) to be 
a parameter to methods, classes, and interfaces.
Code is in the coding folder
```

## Q2.  Read those codes and type it one by one by yourself. the push the code to your branch
```
Code is in the coding folder
```

## Q3.  practice stream API at least 3 times
```
Code is in the coding folder
```

## Q4.  Practice Optional methods at least 2 times
```
Code is in the coding folder
```

## Q5.  Write the Singleton design pattern include eager load and lazy load.
```
### Eager load
private class Singleton  {
    private Singleton() {}
    private static Singleton singletonInstance = new singleton();
    public static synchronized Singleton getInstance() { 
        return singletonInstance;
    }
}

### Lazy Load
private class Singleton  {
    private static Singleton singletonInstance = null;
    private Singleton() {}
    public static synchronized Singleton getInstance() { 
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }
}
```

## Q6.  What is Runtime Exception? could you give me some examples?
```
runtime exceptions are internal to your application but are not typically recoverable.
Example would be NullPointerException
```

## Q7. Could you give me one example of NullPointerException?
```
Calling any methods on a null object
```

## Q8.  What is the Optional class?
```
The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null value
```

## Q9.  What are the advantages of using the Optional class?
```
To deal with possible null values easier.
```

## Q10. What is the @FunctionalInterface?
```
A functional interface is an interface that contains one and only one abstract method
```

## Q11. what is lamda?
```
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are 
similar to methods, but they do not need a name and they can be implemented right in the body of a method
```

## Q12. What is Method Reference?
```
Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by 
referencing existing methods.
```

## Q13. What is Java 8 new features?
```
forEach() method in Iterable interface
default and static methods in Interfaces
Functional Interfaces and Lambda Expressions
Java Stream API for Bulk Data Operations on Collections
Java Time API
Collection API improvements
Concurrency API improvements
Java IO improvements
```

## Q14. Lambda can use unchanged variable outside of lambda? what is the details?
```
the local variables declared outside the lambda expression have to be final or effectively final.
```

## Q15. Describe the newly added features in Java 8?
```
forEach() method in Iterable interface
default and static methods in Interfaces
Functional Interfaces and Lambda Expressions
Java Stream API for Bulk Data Operations on Collections
Java Time API
Collection API improvements
Concurrency API improvements
Java IO improvements
```

## Q16. Can a functional interface extend/inherit another interface?
```
A functional interface can extends another interface only when it does not have any abstract method.
```

## Q17.  What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
```
lambda expressions are used to implement a method defined by a functional interface
```

## Q18. In Java 8, what is Method Reference?
```
Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by 
referencing existing methods.
```

## Q19. What does the String::ValueOf expression mean?
```
Method reference in Java who refers to valueOf method in String.
```

## Q20. What are Intermediate and Terminal operations?
```
Intermediate operations transform or filter elements in a stream, returning a new stream
```

## Q21. What are the most commonly used Intermediate operations?
```
filter(predicate) Method.
sorted() Method.
distinct() Method.
map() Method
```

## Q22. What is the difference between findFirst() and findAny()?
```
find first find the first element and find any return any element
```

## Q23. How are Collections different from Stream?
```
collections are mainly about data and streams are mainly about operations on data
```
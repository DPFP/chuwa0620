### 1 What is generic in Java?
Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types) to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types.

### 5 Write the Singleton design pattern include eager load and lazy load.
eager load
```
public class Singleton{
  private static Singleton instance = new Singleton();

  private Singleton(){
  }

  public static Singleton getInstance(){
    return instance;
  }

}
```

lazy load
```
public class Singleton{
  private Singleton(){
  }

  private static class SingletonHolder{
    private static final Singleton INSTANCE = new Singleton();
  }

  public static Singleton getInstance(){
    return SingletonHolder.INSTANCE;
  }
}
```

### 6 What is Runtime Exception? could you give me some examples?
RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine.  
An object that is expected to have a value but is actually null. In this case, a NullPointerException exception would be thrown.  
ArrayIndexOutOfBoundsException will be thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array.

### 7 Could you give me one example of NullPointerException?
```
public static void main (String[] args){
    String str = null;
    try
    {
        System.out.print(str.equals("aaa"));
    }
    catch(NullPointerException e)
    {
        System.out.print("NullPointerException Caught");
    }
}
```

### 8 What is the Optional class?
The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. The class was introduced in the java. util package to remove the need for multiple null checks to protect against the dreaded NullPointerExceptions during run-time.

### 9 What are the advantages of using the Optional class?
1. An instance of Optional should always be treated properly at compile time to get the value inside of it. This obligation to handle an Optional at compile time results in fewer unexpected NullPointerExceptions.
2. Optional is a useful tool when building our APIs. Optional in the return of a method provides a clear intention of what we should expect from that method: it returns something or nothing.
3. Optional class is the ability to use a chain of fluent methods. It provides a “pseudo-stream” similar to the stream() from collections, but with only one value. That means we can call methods like map(), and filter() on the value in it. That helps to create more declarative programs, instead of imperative ones.

### 10 What is the @FunctionalInterface?
A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.

### 11 what is lamda?
Lambda Expressions were added in Java 8. A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

### 12 What is Method Reference?
Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods.  
There are four kinds of method references: Static methods, Instance methods of particular objects, Instance methods of an arbitrary object of a particular type, Constructor

### 13 What is Java 8 new features?
- forEach() method in Iterable interface.
- default and static methods in Interfaces.
- Functional Interfaces and Lambda Expressions.
- Java Stream API for Bulk Data Operations on Collections.
- Java Time API.
- Collection API improvements.
- Concurrency API improvements.
- Java IO improvements.

### 14 Lambda can use unchanged variable outside of lambda? what is the details?
Yes. The local variables declared outside the lambda expression can be final or effectively final.

### 15 Describe the newly added features in Java 8?
- forEach() method in Iterable interface.
- default and static methods in Interfaces.
- Functional Interfaces and Lambda Expressions.
- Java Stream API for Bulk Data Operations on Collections.
- Java Time API.
- Collection API improvements.
- Concurrency API improvements.
- Java IO improvements.

### 16 Can a functional interface extend/inherit another interface?
A functional interface can extends another interface only when it does not have any abstract method.

### 17 What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
Lambda Expressions were added in Java 8. A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.  
From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface.

### 18 In Java 8, what is Method Reference?
Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods.  
There are four kinds of method references: Static methods, Instance methods of particular objects, Instance methods of an arbitrary object of a particular type, Constructor

### 19 What does the String::ValueOf expression mean?
The valueOf() method converts data into human-readable form.So String valueOf() will return the string representation of the value. The valueOf() method is a static method.

### 20 What are Intermediate and Terminal operations?
Intermediate operations transform or filter elements in a stream, returning a new stream.  
Terminal operations produce a result or side effect, marking the end of a stream. Examples: forEach, collect, reduce, count, min, max, anyMatch, allMatch, noneMatch.

### 21 What are the most commonly used Intermediate operations?
filter, map, distinct, sorted, limit

### 22 What is the difference between findFirst() and findAny()?
The findAny() method returns any element from a Stream, while the findFirst() method returns the first element in a Stream.

### 23 How are Collections different from Stream?
Collections are used to store and group the data in a particular data structure like List, Set, or Map. Whereas Streams are used to perform complex data processing operations like filtering, matching, mapping, etc on stored data such as arrays, collections, or I/O resources.

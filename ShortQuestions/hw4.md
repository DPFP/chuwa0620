1. Generic means parameterized types. Using generics, the idea is to allow any data type to be it Integer, String, or any user-defined Datatype and it is possible to create classes that work with different data types.

   A Generic class simply means that the tems or functions in that class can be generalized with the parameter(example T) to specify that we can add any type as a parameter in place of T like Integer, Character, String, Double or any other user-defined type.

2. Done

3. Done

4. Done

5. ```java
   // eager load
   public class Singleton{
     private static Singleton instance = new Sinlgeton;
     
     private Singleton(){
       
     }
     
     public static Singleton getInstance(){
       return instance;
     }
   }
   
   // lazy load
   
   public class Singleton{
     private static volatile Singleton instance;
     
     private Singleton(){
       
     }
     
     public static Singleton getInstance(){
       if(instance == null){
         synchronized(Singleton.class){
           if(instance == null){
             instance = new Singleton();
           }
         }
       }
       return instance;
     }
   }
   ```

6. runtime exceptions are internal to your application but are not typically recoverable. For example, an object that is expected to have a value but is actually null. In this case, a `NullPointerException` exception would be thrown.

7. ```java
   // this will cause a nullpointer exception
   public Array<Integer> list;
   int i = list.get(3);
   ```

8. The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. The class was introduced in the java.util package to remove the need for multiple null checks to protect against the dreaded NullPointerExceptions during run-time.

9.  

   1.  Prevent NullpointerExceptions caused by missing null check
   2. It provides a “pseudo-stream” similar to the *stream()* from collections, but with only one value. That means we can call methods like *map()*, and *filter()* on the value in it. 

10. A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.

11. A lambda expression is a short block of code which takes in parameters and returns a value. 

12. Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods.

    There are four kinds of method references:

    - Static methods
    - Instance methods of particular objects
    - Instance methods of an arbitrary object of a particular type
    - Constructor

13. Java 8 new features:

    1. forEach() method in Iterable interface
    2. default and static methods in Interfaces
    3. Functional Interfaces and Lambda Expressions
    4. Java Stream API for Bulk Data Operations on Collections

14. Yes, it can use variables from surrounding scope as long as those variable are effectively final.

15. Features:

    1. Lambda Expressions: Enables functional-style programming by providing a concise syntax to represent anonymous functions.
    2. Stream API: Facilitates efficient processing of collections using functional-style operations like filtering, mapping, and reducing.
    3. Default Methods: Allows adding new methods to interfaces without breaking existing implementations.
    4. Optional: Provides a type-safe wrapper for nullable values, avoiding null pointer exceptions.
    5. Method References: Offers a concise way to refer to methods using predefined or custom functional interfaces.

16. An interface can extend other interfaces, just as a class subclass or extend another class. However, whereas a class can extend only one other class, an interface can extend any number of interfaces. The interface declaration includes a comma-separated list of all the interfaces that it extends.

17. ambda expressions are used to implement a method defined by a functional interface. It is the one way to represent one method interface using an expression and helps to iterate, filter, and extract data from the collection (An example is java. lang. Runnable.)

18. Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods.

19. Means the reference of static method Valueof() in String class

20. Intermediate operations transform or filter elements in a stream, returning a new stream. Examples: filter, map, distinct, sorted, limit. Terminal operations produce a result or side effect, marking the end of a stream. Examples: forEach, collect, reduce, count, min, max, anyMatch, allMatch, noneMatch.

21. filter, map, distinct, sorted

22. The findAny() method returns any element from a Stream, while the findFirst() method returns the first element in a Stream. findAny is a nondeterministic method which could return any value inorder maximized the parallel computing.

23. Collections are used to store and group the data in a particular data structure like List, Set, or Map. Whereas Streams are used to perform complex data processing operations like filtering, matching, mapping, etc on stored data such as arrays, collections, or I/O resources. 
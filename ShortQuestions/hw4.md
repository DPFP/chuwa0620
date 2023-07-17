## HW2
### Name: Yuanzhen Lin

### 1. What is generic in Java? and type the generic code by yourself.
Generics are a feature in Java that allows types (classes and interfaces) to be parameters when defining classes, interfaces, and methods. When using the APIs (Application Programming Interfaces) developed by others, generics make it possible for you to check for compile-time type safety.

In simpler terms, generics are like variables, but instead of representing values, they represent types. They are most commonly used in collection classes, like ArrayList and HashMap.

Practice code in MavenProject/generic.

### 2. Read those codes and type it one by one by yourself. the push the code to your branch.
Practice code in MavenProject/java8.

### 3. practice stream API at least 3 times
Practice code in /stream-api-exercise-main directory.

### 4. Practice Optional methods at least 2 times
Practice code in /java8/..../exercise/ShoppingCartPracticeTwo

### 5. Write the Singleton design pattern include eager load and lazy load.
Practice code in genetric/..../singleton

### 6. What is Runtime Exception? could you give me some examples?
RuntimeException is a type of exception that indicates that a problem has occurred during the program's runtime. 
These exceptions are unchecked, which means that the Java compiler does not require the programmer to catch or specify them in a method's throws clause. 
This is in contrast to checked exceptions, which must be caught or specified.

Here are a few common examples of RuntimeExceptions:

- NullPointerException: 
This occurs when you try to call a method or access a property on an object that is actually null.
```
Object obj = null;
obj.toString();  // throws NullPointerException
```

- ArrayIndexOutOfBoundsException: 
This occurs when you try to access an array element using an index that is outside the valid range.
```
int[] array = new int[10];
int number = array[10];  // throws ArrayIndexOutOfBoundsException
```

- NumberFormatException: 
This occurs when you try to convert a String that doesn't represent a valid number into a numeric type.
```aidl
int number = Integer.parseInt("Not a number");  // throws NumberFormatException
```

- ClassCastException: 
This occurs when you try to cast an object to a subclass it doesn't belong to.
```aidl
Object obj = new Integer(10);
String str = (String) obj;  // throws ClassCastException
```

- ArithmeticException: 
This occurs when an exceptional arithmetic condition has occurred. For example, division by zero.
```aidl
int result = 10 / 0;  // throws ArithmeticException
```

### 7. Could you give me one example of NullPointerException?
- NullPointerException:
  This occurs when you try to call a method or access a property on an object that is actually null.
```
Object obj = null;
obj.toString();  // throws NullPointerException
```

### 8. What is the Optional class?
The Optional<T> class in Java is a container object that may or may not contain a non-null value.\
It was introduced in Java 8 as a way to handle null values more effectively and reduce the number of NullPointerExceptions, which are a common source of bugs.\
With Optional, you can represent a method that may not always return a value and the consumer of that method can handle the lack of a value explicitly, rather than dealing with a potential null.

### 9. What are the advantages of using the Optional class?
1. Improved Code Readability: \
Using Optional makes it clear that a method might not always return a value. This makes code easier to understand.
2. Null Safety:\
Optional helps prevent NullPointerExceptions, which are a common source of bugs in Java applications. When used correctly, Optional can help you write programs that are less likely to crash due to unhandled null values.
3. More Expressive API: \
Optional provides a range of methods that allow for more expressive ways of dealing with potential absence of values. Methods like orElse(), orElseGet(), orElseThrow(), ifPresent(), map(), and flatMap() give you powerful tools to work with potential absence of values in a fluent, chainable API.

### 10. What is the @FunctionalInterface?
In Java, @FunctionalInterface is an interface that has exactly one abstract method. While in Java 8 and above any interface with a Single Abstract Method (SAM) can be used as a functional interface, the @FunctionalInterface annotation is used to indicate that the interface is intended to be a functional interface and to enable compile-time checking for this.

### 11. what is lamda?
Lambda expressions were introduced in Java 8 as a part of bringing functional programming concepts to the language. 
A lambda expression is essentially a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

### 12. What is Method Reference?
Method references in Java are a feature introduced in Java 8, along with lambda expressions, to support functional programming concepts.
They provide a way to refer to a method without executing it, and they are useful when you want to pass the behavior of a method as an argument to another method, such as a higher-order function.

### 13. What is Java 8 new features?
1. Lambda Expressions: \
These are anonymous functions which allow users to write functions in a more concise and flexible way, enabling functional programming in Java.

2. Method References: \
Method references provide a way to refer to a method without executing it, and are useful for passing the behavior of a method as an argument.

3. Stream API: \
The Stream API was introduced to work with sequences of data in a functional programming manner. It provides a set of standard methods like filter(), map(), reduce(), collect(), forEach(), etc., that can be used to perform computations on data.

4. Optional class: \
The Optional class is a container object used to contain not-null objects. It is used to represent null with absent value.

5. Default and Static Methods in Interfaces: \
Before Java 8, interfaces could have only abstract methods. In Java 8, interfaces can have default and static methods that allow developers to add new functionality to the interfaces without breaking the classes that implement these interfaces.

6. Functional Interfaces: \
These are interfaces with just one abstract method, and are intended to be used with lambda expressions. Java 8 includes several standard functional interfaces in the java.util.function package.

### 14. Lambda can use unchanged variable outside of lambda? what is the details?
A lambda expression can use local variables from its surrounding scope only if they are final or effectively final.
A variable is effectively final if its value is assigned only once and is never changed after that. 
This means that, even if you don't explicitly declare the variable as final, as long as you don't modify it after initialization, it's considered effectively final.

### 15. Describe the newly added features in Java 8?
- Lambda Expressions: \
This is a key feature of Java 8, introducing functional programming to Java. A lambda expression is essentially an anonymous function that you can use to create delegates or pass functionality as an argument to a method.

- Method References: \
These provide a way to refer directly to a method without invoking it. They are a kind of shorthand mechanism for creating lambda expressions for methods that already have a name.

- Default Methods: \
Also known as Defender Methods, these are methods with a default implementation in the interfaces. This feature helps in extending interfaces without fearing the break of implementation classes.

- Functional Interfaces: \
These are interfaces that have only one abstract method, aside from the methods of the Object class. They can be used anywhere an object is expected and can be instantiated using lambda expressions, method references, or constructor references.

- Stream API: \
This new API works with both finite and infinite sequences of data in a functional programming way. It supports pipeline processing of data and can be used in conjunction with various methods to perform complex data processing pipelines.

- Optional class: \
The Optional class in Java 8 is a public final class and used to deal with NullPointerException in Java application. It provides methods to check the presence of value for particular variable.

### 16. Can a functional interface extend/inherit another interface?
Yes, a functional interface can extend another interface, but there is a rule that it needs to follow: The functional interface must still only have one abstract method.

This rule applies even when considering abstract methods from all of the interface's ancestors in the inheritance tree. If an interface extends another interface, the child interface inherits all the parent interface's methods. If the child interface does not add any additional abstract methods, it can still be a functional interface if the parent interface is a functional interface.

### 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
A lambda expression is essentially a short block of code which takes in parameters and returns a value. It's similar to a method, but without a name, and can be defined right in the body of a method. The basic syntax of a lambda expression is either (parameter) -> expression or (parameter) -> { statements; }.

A functional interface is an interface that contains exactly one abstract method (excluding the methods from Object). The single abstract method can be considered a "function" to be executed. Therefore, functional interfaces are designed to be used in scenarios where an instance of an object is needed to represent a single action.

Lambda expressions in Java are primarily used to define the implementation of a method declared in a functional interface, right at the place of method call. You can assign a lambda expression to a variable whose type is a functional interface, and then call the method defined in the functional interface on that variable to execute the code in the lambda expression.

### 18. In Java 8, what is Method Reference?
In Java 8, a method reference provides a way to refer to a method without invoking it. It's often used to create simple lambda expressions that call existing methods directly.

### 19. What does the String::ValueOf expression mean?
In Java, String::valueOf is a method reference to the static valueOf method in the String class.

The String.valueOf() method is a static method that converts different types of values into string. It has several overloaded versions for different parameter types including objects, integers, booleans, characters, floats, doubles, etc. It's commonly used to convert non-string values to a string.

### 20. What are Intermediate and Terminal operations?
- Intermediate Operations:

Intermediate operations are operations that transform a Stream into another Stream. They are always lazy, meaning that they do not process the elements of the Stream immediately. Instead, they just store the operation to be performed and apply it only when a terminal operation is invoked on the Stream.

- Terminal Operations:

Terminal operations produce a result or a side-effect. When a terminal operation is invoked on a Stream, the Stream is "consumed" and can no longer be used. After that point, if you want to traverse over the elements again, you will have to create a new Stream.

### 21. What are the most commonly used Intermediate operations?
- filter(Predicate predicate): \
Returns a stream consisting of the elements of the original stream that match the given predicate. The predicate is a functional interface that takes an element and returns a boolean.

- map(Function mapper): \
Transforms the stream by applying a function to each element. The function takes an element and returns a new element.

- flatMap(Function mapper): \
Similar to map, but each input element can be mapped to multiple output elements (by returning a stream of output elements). The output streams are then combined into a single stream.

- distinct(): 
Returns a stream consisting of the distinct elements of the original stream. It uses Object.equals(Object) to determine equality.

- sorted(): \
Returns a stream consisting of the elements of the original stream, sorted according to their natural ordering, or by a provided Comparator.

- peek(Consumer action): \
Returns a stream consisting of the elements of the original stream, additionally performing the provided action on each element as they are consumed from the resulting stream. This can be useful for debugging.

- limit(long maxSize): \
Returns a stream that is no longer than the given size. The elements in the returned stream are the same as the first elements of this stream.

- skip(long n): \
Returns a stream that discards the first n elements of this stream. If this stream has fewer than n elements, an empty stream is returned.

### 22. What is the difference between findFirst() and findAny()?
- findFirst():\
This returns the first element from the stream. If the stream has defined an encounter order (like a List), then it will return the first element in that order. In a parallel stream scenario, this can be quite costly because findFirst() needs to ensure that it returns the first element according to the encounter order, and so it must coordinate between multiple threads, which can slow down the processing.
- findAny(): \
This returns any element from the stream. In a parallel stream scenario, this is usually faster than findFirst() because it doesn't need to coordinate between threads to find any particular element, just whichever one finishes first. This might not always return the same element every time if the stream is parallelized.

### 23. How are Collections different from Stream?
- Iteration: The most noticeable difference between Collections and Streams relates to their iteration. In Collections, the user explicitly handles the iteration using for-each loops or iterators. In contrast, Streams handle iteration implicitly behind the operations.

- Data handling: Collections can store or represent a finite number of data elements. On the other hand, a Stream is a sequence of data elements which can be sequential or parallel, and it can also process an infinite number of data elements.

- Use Cases: Collections are primarily concerned with the efficient management of and access to data, whereas Streams are more focused on aggregate computations, often in parallel, such as filtering, mapping, or extracting data.

- Mutability: Operations on Collections are typically used to modify the collection itself. For example, if you iterate over a collection to remove or add elements, you're changing the collection directly. On the other hand, Streams operations do not modify its source of data. Instead, they return a new Stream that includes the result.

- Consumability: Streams are consumable, meaning an operation on a Stream performs on each element, but it does not modify the backing data source. Also, it can be iterated only once. After that, it will t



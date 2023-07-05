#### 1. What is generic in Java? and type the generic code by yourself.

a. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

Done

#### 2. Read those codes and type it one by one by yourself. the push the code to your branch.

https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

Done

#### 3. Practice stream API at least 3 times

 https://blog.devgenius.io/15-practical-exercises-help-you-master-javastream-api-3f9c86b1cf82

Done

#### 4. Practice Optional methods at least 2 times

 https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t0_java8/exercise/ShoppingCartUtil.java

Done

#### 5. Write the Singleton design pattern include eager load and lazy load.

**Eager Load:**
In eager initialization, the instance of Singleton Class is created at the time of class loading. This is the easiest method to create a singleton class.

```Java
public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();
    
    // private constructor to avoid client applications to use constructor
    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return instance;
    }
}

```

**Lazy Load**:

In lazy initialization, the Singleton instance is created when the client needs it. This is the most common method to create the Singleton class.

```Java
public class SingletonLazy {
    private static SingletonLazy instance;

    // private constructor to avoid client applications to use constructor
    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}

```

In the above SingletonLazy class, the Singleton instance is not created at the time of class loading. It is created when the client calls the `getInstance` method. This is the most common way to create a Singleton class. The client can use the Singleton instance as required, but it will be created only when needed. This is known as lazy initialization.

#### 6. What is Runtime Exception? could you give me some examples?

Unchecked Exception. RuntimeException is *the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine*

- NullPointerException (NPE)
- IndexOutOfBoundsException

#### 7. Could you give me one example of NullPointerException?

Some of the most common scenarios for a NullPointerException are: **Calling methods on a null object**. 

```Java
public class NullPointerExceptionExample {
    private static void printLength(String str) {
        System.out.println(str.length());
    }

    public static void main(String args[]) {
        String myString = null;
        printLength(myString);
    }
}
```

In this example, the `printLength()` method calls the `length()` method of a String without performing a null check prior to calling the method. Since the value of the string passed from the `main()` method is null, running the above code causes a `NullPointerException`:

#### 8. What is the Optional class?

The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. 

#### 9. What are the advantages of using the Optional class?

It can help in writing a neat code without using too many null checks

#### 10. What is the @FunctionalInterface?

An informative annotation type used **to indicate that an interface type declaration is intended to be a functional interface as defined by the Java Language Specification**. Conceptually, a functional interface has exactly one abstract method.

#### 11. what is Lambda?

A lambda expression is **a short block of code which takes in parameters and returns a value**. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

#### 12. What is Method Reference?

Method reference is used **to refer method of functional interface**. 

It is used to refer to a method without invoking it. :: 
`class::method`

#### 13. What are Java 8 new features?

| Feature Name          | Description                                                  |
| :-------------------- | :----------------------------------------------------------- |
| Lambda expression     | A function that can be shared or referred to as an object.   |
| Functional Interfaces | Single abstract method interface.                            |
| Method References     | Uses function as a parameter to invoke a method.             |
| Default method        | It provides an implementation of methods within interfaces enabling 'Interface evolution' facilities. |
| Stream API            | Abstract layer that provides pipeline processing of the data. |
| Optional              | Wrapper class to check the null values and helps in further processing based on the value. |

#### 14. Lambda can use unchanged variable outside of lambda? what is the details?

Yes.

As long as the address of this variable is unchanged, it can be used by lambda.



#### 15. Describe the newly added features in Java 8?

| Feature Name          | Description                                                  |
| :-------------------- | :----------------------------------------------------------- |
| Lambda expression     | A function that can be shared or referred to as an object.   |
| Functional Interfaces | Single abstract method interface.                            |
| Method References     | Uses function as a parameter to invoke a method.             |
| Default method        | It provides an implementation of methods within interfaces enabling 'Interface evolution' facilities. |
| Stream API            | Abstract layer that provides pipeline processing of the data. |
| Optional              | Wrapper class to check the null values and helps in further processing based on the value. |

#### 16. Can a functional interface extend/inherit another interface?

A functional interface cannot extend another interface with abstract methods.

Because it will void the rule of one abstract method per functional interface.

```Java
public int parentMethod(); 
} 
@FunctionalInterface // This cannot be FunctionalInterface 
interface Child extends Parent { 
public int childMethod(); 
// It will also extend the abstract method of the Parent Interface 
// Hence it will have more than one abstract method 
// And will give a compiler error 
}
```

However, it can extend other interfaces which do not have any abstract method and only have the default, static, another class is overridden, and normal methods.

```Java
interface Parent { 
public void parentMethod(){ 
System.out.println("Hello"); 
} 
} 
@FunctionalInterface 
interface Child extends Parent { 
public int childMethod(); 
}
```



#### 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

A lambda expression is **a short block of code which takes in parameters and returns a value**. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

lambda expressions are **used to implement a method defined by a functional interface**. 

#### 18. In Java 8, what is Method Reference?

Method reference is used **to refer method of functional interface**. 

It is used to refer to a method without invoking it. :: 
`class::method`

#### 19. What does the String::ValueOf expression mean?

It is a static method reference to method `Valueof()` of class String. 

It will return the string representation of the argument passed.

#### 20. What is an Optional class?

The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. 

#### 21. What are Intermediate and Terminal operations?

Intermediate operations transform or filter elements in a stream, returning a new stream. 

Terminal operations produce a result or side effect, marking the end of a stream. 

#### 22. What are the most commonly used Intermediate operations?

 sorted() , distinct() , limit() , skip() ,map()

#### 23. What is the difference between findFirst() and findAny()?

| findFirst()                             | findAny()                          |
| :-------------------------------------- | :--------------------------------- |
| Returns the first element in the Stream | Return any element from the Stream |
| Deterministic in nature                 | Non-deterministic in nature        |

#### 24. How are Collections different from Stream?

| Collections                                | Streams                                                      |
| :----------------------------------------- | :----------------------------------------------------------- |
| Data structure holds all the data elements | No data is stored. Have the capacity to process an infinite number of elements on demand |
| External Iteration                         | Internal Iteration                                           |
| Can be processed any number of times       | Traversed only once                                          |
| Elements are easy to access                | No direct way of accessing specific elements                 |
| Is a data store                            | Is an API to process the data                                |

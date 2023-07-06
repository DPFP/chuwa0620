# Chuwa 0620 Assignment 3

### Zhizhou Xu

1. **What is generic in Java? Type the generic code by yourself.**  
   Generics allow users to create classes, interfaces, and methods that can work with different types of objects while providing type safety. They enable you to parameterize types so that you can use the same code with different data types.  
    ```java
    public class Vehicle<T> {
        private T wheel;
    
        public T getWheel() {
            return wheel;
        }
    
        public void setWheel(T wheel) {
            this.wheel = wheel;
        }
    }
    ```
   
2. **Write the Singleton design pattern include eager load and lazy load.**  
    ```java
   // eager
    public class Singleton {
        private Singleton(){}
   
        private static Singleton instance;
        static {
           instance = new Singleton();
       }
       public static Singleton getInstance(){
           return instance;
       }
   }
   
   // lazy
   public class Singleton {
        private Singleton(){}

        private static volatile Singleton instance;
        public static Singleton getInstance(){
            if(instance == null){
                synchronized (Singleton.class){
                    if(instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
   }
   ```
3. **What is Runtime Exception? could you give me some examples?**  
   Runtime exceptions in Java are unchecked exceptions that occur during program execution. They are typically caused by programming errors or unexpected conditions. Here are some common examples:
   - `NullPointerException`: Accessing or invoking a method on a null object reference.

   - `ArrayIndexOutOfBoundsException`: Accessing an array element with an invalid index.

   - `ArithmeticException`: Performing an arithmetic operation that results in an exceptional condition (e.g., division by zero).

4. **Could you give me one example of NullPointerException?**  
   ```java
   String s = null;
   int len = s.length();
   ```

5. **What is the Optional class?**  
   The `Optional` class is a container class introduced in Java 8 that is designed to provide a more expressive way of dealing with null values.

6. **What are the advantages of using the Optional class?**  
Avoid NullPointerException. More readable code. Chain operations.

7. **What is the @FunctionalInterface?**  
A functional interface is an interface that contains only one abstract method and is used as the basis for lambda expressions or method references in functional programming.

8. **What is lambda in Java?**  
   A lambda expression is a concise way to represent an anonymous function—a function without a name that can be passed around as a parameter or stored in a variable. It is a key feature introduced in Java 8 as part of the functional programming enhancements.

9. **What is Method Reference?**  
Method reference is a shorthand syntax that allows you to refer to a method without invoking it. It provides a concise way to pass methods as arguments, assign them to variables, or use them in functional interfaces. 

10. **What is Java 8 new features?**  
    - Lambda expressions: Concise syntax for representing anonymous functions.

    - Stream API: Declarative way to process collections of data.

    - Default methods: Interface methods with default implementations.

    - Method references: Shorthand syntax for referring to existing methods.

    - Optional: Expressive handling of null values.

11. **Lambda can use unchanged variable outside of lambda? What are the details?**  
    Lambda expressions in Java can access variables from the enclosing scope as long as those variables are effectively final or, in other words, they are not modified after their initial assignment.  
12. **Describe the newly added features in Java 8?**  
    Stream API: The Stream API in Java provides a way to process collections of data in a functional programming style. It allows you to perform operations on the elements of a collection, such as filtering, mapping, and reducing, in a declarative and efficient manner.
13. **Can a functional interface extend/inherit another interface?**  
    The extended interface can have additional default methods or static methods, but it must still have only one abstract method to remain a functional interface.  
14. **What is the lambda expression in Java and How does a lambda expression relate
    to a functional interface?**  
    The lambda expression provides the implementation of the single abstract method of the functional interface, allowing you to write concise and expressive code.
15. **In Java 8, what is Method Reference?**  
    They allow you to treat a method as a value that can be passed around or stored in a variable. Method references are closely related to lambda expressions and can be used in place of lambda expressions in certain scenarios.  
16. **What does the String::ValueOf expression mean?**  
    The `String::valueOf` expression is a method reference in Java. It refers to the `valueOf()` method of the `String` class. 
17. **What are Intermediate and Terminal operations?**  
    - Intermediate operations transform or filter the elements of a stream and return a new stream. They are typically lazy and are chained together to form a processing pipeline.
    - Terminal operations produce a result or a side-effect and trigger the execution of the stream. Once a terminal operation is performed, the stream cannot be used again.
18. **What are the most commonly used Intermediate operations?**  
    `filter`, `map`, `distinct`, `sorted`, `limit`, and `skip`.
19. **What is the difference between `findFirst()` and `findAny()`?**  
    `findFirst()` operation returns the first element from the stream. `findAny()` operation returns any element from the stream. It does not guarantee the first element in the encounter order, and the element returned can vary between different runs or different execution environments.
20. **How are Collections different from Stream?**  
    Collections are data structures that store and manage elements, providing random access and modification capabilities. Streams, on the other hand, are a sequence of elements that can be processed in a pipeline-like manner, allowing functional-style operations on data. 
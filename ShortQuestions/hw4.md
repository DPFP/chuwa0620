# HW4
1. What is generic in Java? and type the generic code by youself.
    - https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

    - Generic provides a way to create classes, interfaces, and methods that can work in different data types.


2. Read those codes and type it one by one by yourself. the push the code to your branch.
   - https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

3. practice stream API at least 3 times
   - https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82


4. practice Optional methods at least 2 times
   - https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java


5. Write the Singleton design pattern include eager load and lazy load.
    ```
    // eager load
    public class Singleton{
        private Singleton() {}

        private static Singleton instance = new Singleton();

        public static Singleton getInstance(){
            return instance;
        }
    }

    // lazy load
    public class Singleton{
        private Singleton(){}
        private static Singleton instance;

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

    ```


6. What is Runtime Exception? could you give me some examples?
   - The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur.
   - NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException, InvalidArgumentException etc.


7. Could you give me one example of NullPointerException?
   - Initializing String variable with null value then using `variable.equals()`.


8. What is the Optional class?   
   - The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. The class was introduced in the java. util package to remove the need for multiple null checks to protect against the dreaded NullPointerExceptions during run-time.


9. What are the advantages of using the Optional class?
   - it is very hard to avoid NullPointerException without using too many null checks
   - to overcome it, Java 8 has introduced a new class Optional in java.util package, it can help to write a neat code without using too many null checks to avoid NullPointerException 
   - we can specify alternate values to return or alternate code to run for null, which makes the code more readable because the facts which were hidden are now visible to the developer


10. What is the @FunctionalInterface?
   - A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.


11. what is lamda?
   - A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.


12. What is Method Reference?
   - Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods. There are four kinds of method references: Static methods. Instance methods of particular objects. Instance methods of an arbitrary object of a particular type.


13. What is Java 8 new features?
    - Default method in interface
    - Lambda expression
    - Optional
    - Method Reference
    - Stream API


14. Lambda can use unchanged variable outside of lambda? what is the details?
   - Lambda can use final variable, unchanged variable or a variable not declared in current scope outside of lambda. This is because `The restriction to effectively final variables prohibits access to dynamically-changing local variables, whose capture would likely introduce concurrency problems.`

15. Describe the newly added features in Java 8?
    - **Default method in interface**: allow an interface has the concrete default methods
   
    - **Static method in interface**: allow an interface has the concrete static methods, which cannot be **overridden** int the implementation classes
    
    - **Functional interface**:
        - has exactly one abstract method
        - can have default methods
        - '@FunctionalInterface' for a sanity check
        - the abstract method can be implemented by Lambda and method references 
            
    - **Lambda**:
        - replace an anonymous inner class
        - work with a functional interface
        - Lambda can use unchanged variable outside itself
            
    - **Optional**: avoid NullPointerExceptions which belongs to the runtime exception without null-checks 

    - **Method reference**
    
    - **Stream API**


16. Can a functional interface extend/inherit another interface
    - Yes, but we need the child functional interface still have exactly one abstract method to be considered as a functional interface


17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
    - lambda is introduced for concise anonymous function call or method implementation.  
    - functional interface could be implemented by lambda expression directly and concisely.


18. In Java 8, what is Method Reference?
    - It is the compact and easy form of a lambda expression. Each time when you are using a lambda expression to just referring a method, you can replace your lambda expression with the method reference. 

    Types of method references:
    - reference to a static method
    - reference to an instance method
    - reference to a constructor

19. What does String::ValueOf expression mean?
    - It's a method reference in Java who refers to valueOf method in String.


20. What are Intermediate and Terminal operations?
    - Intermediate: filter, map, flatMap, distinct, sorted, limit, and skip
    - Terminal: forEach, collect, reduce, count, anyMatch, allMatch, noneMatch, and findFirst

21. What are the most commonly used Intermediate operations?
    - map
    - filter
    - sorted
    - distinct
    - flatmap
    - skip
    - limit

22. What is the difference between findFirst() and findAny()?
    - findFirst(): to find the first element in stream.
    - findAny(): to find a chosen element in any order in stream.

23. How are Collections different from Stream?
    - Data Structure: Collections represent data structure while streams are just a sequence of elements that can be processed in a pipeline.
    - Eager vs Lazy Evaluation: Collections have an eager evaluation strategy while Stream have a lazy evaluation strategy. (defer until a terminal operation is invoked, so more efficient)
    - Mutability: Collections can change while streams do not change the source of data.
    - One-time Usage: Collections can be iterated multiple times, while streams cannot be reused.

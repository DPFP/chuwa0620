**1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo 
repo as example)**

1. Encapsulation;

   ```java
   public Person {
       private int age;
       private String name;
       public void setAge(int age) {
           this.age = age;
       }
        public void setName(String name) {
           this.name = name;
       }
        public int getAge() {
           return this.age;
       }
        public String getName() {
           return this.name;
       }
   }
   ```

   

2. Polymorphism;

   ```java
   public class Calculator {
       public int add(int a, int b) {
           return a + b;
       }
   
       public double add(double a, double b) {
           return a + b;
       }
   }	
   ```

   

3. Inheritance; 

   ```java
   class Vehicle {
   	int year;
       String make;
   }
   class Truck extends vehicle {
       int bedLength;
   }
   ```

   

**2. What is wrapper class in Java and Why we need wrapper class? **

1. Object-oriented operations: Java is primarily an object-oriented language, and many APIs and libraries work with objects. However, primitive types are not objects. Wrapper classes bridge this gap by allowing primitive types to be used in object-oriented contexts.
2. Conversion and compatibility: Wrapper classes provide methods to convert between primitive types and their corresponding wrapper objects. This conversion is necessary when interacting with APIs that expect objects instead of primitives. For example, when using collections like `ArrayList` or `HashMap`, which can only store objects.
3. Utility methods and constants: Wrapper classes provide various utility methods for performing operations on their corresponding data types. For example, the `Integer` class provides methods to parse strings as integers, perform arithmetic operations, and access constants such as maximum and minimum values.
4. Nullability and default values: Wrapper classes can represent `null` values, unlike primitive types. This is useful when we need to indicate the absence of a value or when working with APIs that may return null. Additionally, wrapper classes have default values (`null` for objects) when not explicitly initialized, whereas primitive types have default values (0, 0.0, false) based on their types.
5. Generics: Generics in Java primarily work with objects, not primitive types. Therefore, if we want to use a primitive type as a generic parameter, we need to wrap it with the corresponding wrapper class.

**5. What is Java garbage collection?**

Java garbage collection is an automatic memory management process in Java that frees up memory occupied by objects that are no longer in use. It eliminates the need for manual memory deallocation and helps prevent memory leaks.

**6.  What are access modifiers and their scopes in Java? **

`public`: The public access modifier allows unrestricted access from any part of the program, including other classes and packages.

`private`: The private access modifier restricts access to within the same class. It prevents access from other classes or packages.

`protected`: The protected access modifier allows access from within the same class, subclasses (even if they are in different packages), and other classes in the same package.

Default (no modifier): If no access modifier is specified, the default access modifier is applied. It allows access within the same package but restricts access from other packages.

**7.  What is final key word? (Filed, Method, Class)**

Final Field: When a field is declared as `final`, its value cannot be modified once it is assigned. It remains constant throughout the lifetime of the object. Final fields are typically used for constants or values that should not be altered.

Final Method: When a method is declared as `final`, it cannot be overridden by subclasses. It ensures that the method implementation in the superclass is the final and definitive version that cannot be changed.

Final Class: When a class is declared as `final`, it cannot be subclassed or extended. It prevents inheritance and ensures that the class cannot have any subclasses.

**8. What is static keyword? (Filed, Method, Class). When do we usually use it?**

Static Field: When a field is declared as `static`, it belongs to the class rather than individual instances of the class. There is only one copy of the static field shared among all instances of the class. Static fields are often used to store common data or constants that are shared across instances.

Static Method: When a method is declared as `static`, it belongs to the class and can be invoked without creating an instance of the class. Static methods cannot directly access non-static fields or call non-static methods, as they do not operate within the context of a specific instance.

Static Class (Nested): In Java, it is also possible to define a static nested class, which is a class that is declared as a member of another class and marked as `static`. A static nested class can be accessed without creating an instance of the enclosing class.

The `static` keyword is commonly used in various scenarios, including:

- Defining constants: Static fields can be used to declare constants that remain the same across all instances of a class.
- Utility methods: Static methods can be used to define utility or helper methods that perform common tasks and don't require access to instance-specific data.
- Factory methods: Static methods can be used as factory methods to create instances of a class without explicitly using the constructor.
- Managing shared resources: Static fields can be used to manage shared resources, such as database connections or file handles, that need to be accessed by multiple instances of a class.

**9. What is the differences between overriding and overloading?**

Overriding: Modifying inherited method in subclass.

Overloading: Creating multiple methods with the same name but different parameters.

**10. What is the differences between super and this?**

`super` is used to refer to the superclass, while `this` is used to refer to the current instance of the class.

**11. What is the Java load sequence?**

1. Compilation: Java source code is compiled into bytecode.
2. Class Loading: Classes are dynamically loaded into memory as they are needed.
3. Class Initialization: Static variables and initialization blocks are executed.
4. Object Creation: Memory is allocated for objects and instance variables are initialized.
5. Constructor Execution: Constructors are invoked to initialize objects.
6. Method Execution: Methods can be invoked to perform operations.

**12. What is Polymorphism ? And how Java implements it ? **

In Java, polymorphism is implemented through method overriding and method overloading. Method overriding occurs when a subclass provides its own implementation of a method defined in its superclass, allowing objects of the subclass to be used in place of superclass objects. Method overloading, on the other hand, allows multiple methods with the same name but different parameter lists to exist within a class or across different classes.

**13. What is Encapsulation ? How Java implements it? And why we need encapsulation? **

Encapsulation in Java is achieved by combining data and methods into a class, using access modifiers to control access to variables and methods. It ensures data security, code maintainability, and provides a consistent interface for interacting with objects.

**14. What is Interface and what is abstract class? What are the differences between them?**

Interface: Defines a contract for classes to implement. Contains method signatures only. Supports multiple inheritance. Cannot be instantiated.

Abstract class: Cannot be instantiated, meant to be extended. Can contain method signatures and implemented methods. Supports single inheritance.

**15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )**

1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type 
   it.(Do NOT just copy and paste)

**16. What are Queue interface implementations and what are the differences and when to use what? **Queue interface implementations in Java include LinkedList, ArrayDeque, and PriorityQueue.

- Use LinkedList or ArrayDeque for general-purpose queues.
- Use ArrayDeque when you need a dynamic-sized queue.
- Use PriorityQueue for priority-based processing. Consider performance characteristics and expected usage patterns when selecting an implementation.
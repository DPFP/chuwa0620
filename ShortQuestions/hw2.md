# Chuwa 0620 Assignment 2

### Zhizhou Xu

1.  **Write up example code to demonstrate three fundemental concepts in OOP.**

    - Encapsulation

    ```Java
    public class Vehicle{
        // Encapsulate vehicle Properties using private access moditier
        private String make;
        private String model;
        private String year;

        // Constructor
        public Vehicle(String vMake, String vModel, String vYear){
            make = vMake;
            model = vModel;
            year = vYear;
        }

        // Get and Set propertiy values using getter and setter funtions
        public String getMake(){
            return this.make;
        }
        public String getModel(){
            return this.model;
        }
        public String getYear(){
            return this.year;
        }

        public void setMake(String newMake){
            this.make = newMake;
        }
        public void setModel(String newModel){
            this.model = newModel;
        }
        public void setYear(String newYear){
            this.year = newYear;
        }
    }
    ```

    - Inheritance

    ```Java
    public class Car extends Vehicle{
        // Constructor
        public Car(String cMake, String cModel, String cYear){
            super(cMake, cModel, cYear);
        }
    }
    ```

    - Polymorphism

    ```Java
    // Static polymorphism: Overload
    public class Car{
        private int year;
        private int mileage;

        // Constructor
        public Car(){}

        // Functions with same name but different parameters and/or return types
        public int getCarAge(Integer currYear){
            return currYear - year;
        }
        public int getCarAge(){
            return mileage;
        }
    }

    // Dynamic polymorphism: Override
    public class Sedan extends Car{
        public Sedan(){}

        // Override the same function in parent class
        @Override
        public int getCarAge(Integer currYear){
            return currYear;
        }
    }
    ```

2.  **What is wrapper class in Java and Why we need wrapper class?**

    In Java, a wrapper class is a class that encapsulates a primitive data type, such as int, float, boolean, etc., and provides a way to treat them as objects.

3.  **What is the difference between HashMap and HashTable?**

    - Synchronization: `HashTable` is synchronized (thread-safe), while `HashMap` is not synchronized by default.
    - Null keys and values: `HashTable` does not allow null keys or values, whereas `HashMap` allows both.
    - Performance: `HashMap` generally performs better due to its lack of synchronization overhead. `HashTable` may be slower in multi-threaded scenarios.
    - Iteration: `HashTable` uses a legacy Enumeration for iteration, while `HashMap` provides a fail-fast Iterator.
    - Inheritance: `HashTable` extends the Dictionary class and is a legacy class, while `HashMap` is part of the Collections Framework.

4.  **What is String pool in Java and why we need String pool?**

    The string pool in Java is a memory area where string literals are stored. It allows for memory efficiency by reusing existing string literals and ensures string immutability. Benefits of the string pool include reduced memory consumption, improved performance, efficient string comparison, and thread safety.

5.  **What is Java garbage collection?**

    Java garbage collection is an automated process that manages memory by reclaiming unused objects. It eliminates manual memory management, ensures memory is released when objects are no longer needed, and simplifies programming by preventing memory leaks and dangling pointers.

6.  **What are access modifiers and their scopes in Java?**

    - `public`: Accessible from anywhere in the program.
    - `private`: Accessible only within the same class.
    - `protected`: Accessible within the same class, subclasses, and the same package.
    - `default`: Accessible within the same class and the same package.

7.  **What is final key word? (Filed, Method, Class)**

    - final field: a field's value cannot be changed
    - final method: a method cannot be overriden
    - final class: a class cannot be subclassed

8.  **What is static keyword? (Filed, Method, Class). When do we usually use it?**

    - **Static Fields**: When applied to a field, the static keyword makes the field shared among all instances of the class. This means that the field's value is common to all objects of that class, and modifying it in one instance will affect its value in all other instances.
    - **Static Methods**: When applied to a method, the static keyword indicates that the method belongs to the class itself rather than to any particular instance of the class. Static methods can be called directly on the class, without the need for an instance. They can only access other static members of the class and cannot access instance-specific members.
    - **Static Classes**: In Java, the static keyword cannot be used to directly modify classes. However, when applied to an inner class (a class defined within another class), it indicates that the inner class does not require an instance of the enclosing class to be instantiated. This allows you to access the static members of the outer class without creating an instance of it.

9.  **What is the differences between overriding and overloading?**

    Overloading allows multiple methods with the same name but different parameters within a class, while overriding enables a subclass to provide its implementation of a method defined in the superclass. Overloading is determined at compile-time, whereas overriding is determined at runtime.

10. **What is the differences between super and this?**

    super is used to refer to the superclass and access its members in a subclass, while this is used to refer to the current instance of a class and differentiate between instance variables and parameters/variables with the same name.

11. **What is the Java load sequence?**

    1. Compilation: Java source code is compiled into bytecode using a Java compiler. The resulting bytecode is stored in .class files.
    2. Class Loading: The Java Virtual Machine (JVM) loads classes as they are needed during the execution of the program. Classes are loaded from the file system or other sources such as network locations or dynamically generated code.
    3. Class Verification: The JVM verifies the bytecode of the loaded classes to ensure its correctness and security. It checks for syntactic and semantic errors, verifies bytecode instructions, and ensures that the class adheres to Java's safety rules.
    4. Class Preparation: Memory is allocated for static fields, and default values are assigned to them. This step also involves initializing static constants and creating a method area to store the runtime representation of the class.
    5. Class Initialization: Static initialization blocks and static variable initializations are executed in the order they appear in the code. This step includes executing static constructor blocks and initializing static variables with explicit values.
    6. Instance Creation: Objects or instances of classes are created using the new keyword or through other object creation mechanisms. Memory is allocated on the heap to store instance variables and non-static fields.
    7. Instance Initialization: Non-static initialization blocks and non-static variable initializations are executed in the order they appear in the code. Instance variables are initialized with explicit values or default values.
    8. Constructor Execution: The constructor of the class is executed to perform any additional initialization required for the object.

12. **What is Polymorphism? And how Java implements it?**

    Polymorphism allows objects of different types to be treated as objects of a common superclass type. It enables the use of a single interface to represent different forms or behaviors.
    In Java, polymorphism is primarily achieved through two mechanisms: method overriding and method overloading.

13. **What is Encapsulation ? How Java implements it? And why we need encapsulation?**
    Encapsulation in Java is the practice of combining data and methods into a single unit called a class. It is achieved through access modifiers (such as `private`, `protected`, and `public`) and **getter** and **setter** methods. Encapsulation hides the internal details of an object and provides a controlled interface for interacting with it. It enhances data security, promotes code flexibility, simplifies maintenance, and enables code reusability and abstraction.

14. **What is Interface and what is abstract class? What are the differences between them?**

    - Interface:

      - An interface in Java defines a set of methods that a class must implement.
      - It cannot contain instance variables or constructors.
      - Multiple interfaces can be implemented by a class, enabling multiple inheritance of behavior.
      - Interfaces provide full abstraction without specifying implementation details.

    - Abstract Class:

      - An abstract class in Java cannot be instantiated and serves as a blueprint for derived classes.
      - It can have both abstract and non-abstract methods.
      - An abstract class can contain instance variables, constructors, and other features similar to a regular class.
      - A class can extend only one abstract class, as Java does not support multiple inheritance of classes.
      - Abstract classes define common behavior and characteristics to be inherited by derived classes.

    - Differences:
      - An interface only declares methods, while an abstract class can have both abstract and concrete methods.
      - An interface cannot be instantiated directly, while an abstract class cannot be instantiated unless it is subclassed.
      - A class can implement multiple interfaces, but it can inherit from only one abstract class.
      - Interfaces do not have fields or constructors, while abstract classes can have them.
      - Interfaces provide full abstraction, while abstract classes offer partial abstraction.
      - Interfaces are commonly used to define contracts or common behavior for unrelated classes, while abstract classes are used when there is shared behavior among related classes.

15. **See details in /Coding derectory**

16. **What are Queue interface implementations and what are the differences and when to use what?**

    - `LinkedList`: Efficient implementation of a queue using a doubly-linked list. Recommended for frequent insertion or deletion at both ends of the queue.

    - `ArrayDeque`: Resizable array-based implementation of a double-ended queue. Offers better performance than `LinkedList` in most cases. Recommended for efficient insertion or deletion at both ends of the queue.

    - `PriorityQueue`: Provides priority-based ordering of elements. Recommended when elements need to be processed based on priority or ordering.

    **Different usescases**:

    - For a basic FIFO queue: `LinkedList` or `ArrayDeque` can be used.
    - For efficient insertion or deletion at both ends: `ArrayDeque` is preferred.
    - For priority-based ordering: `PriorityQueue` is the appropriate choice.

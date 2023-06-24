# HW1
**1. Three foundmental concepts of OOP**
- Encapsulating
```
class User {
    private String name;
    private int id;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Jacob");
        user.setId(12345678);

        System.out.println("Name: " + user.getName());
        System.out.println("Id: " + user.getId());
    }
}
```
Output:
```
Name: Jacob
Id: 12345678
```

- Polymorphism
```
class Animal {
    public void sound() {
        System.out.println("Animal makes sounds.");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof Woof.");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow Meow.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.sound();
        animal2.sound();
    }
}
```
Output:
```
Woof Woof.
Meow Meow.
```

- Inheritance
```
class Vehicle {
    public int weight;
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public void print_info() {
        System.out.println("This is a vehicle");
    }
}

class Car extends Vehicle {
    private int num_seats;
    
    public Car (int n) {
        this.num_seats = n;
    }
    
    @Override
    public void print_info() {
        System.out.println("This is a car.");
        System.out.println("Number of seats: " + this.num_seats);
    }
}

class Motorcycle extends Vehicle {
    private int tank_volume;
    
    public Motorcycle (int vol) {
        this.tank_volume = vol;
    }
    
    @Override
    public void print_info() {
        System.out.println("This is a motorcycle");
        System.out.println("Tanl volume: " + this.tank_volume);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car(5);
        Motorcycle motor = new Motorcycle(20);

        car.setWeight(200);
        motor.setWeight(50);
        
        car.print_info();
        motor.print_info();
    }
}
```
Output:
```
This is a car.
Number of seats: 5
This is a motorcycle
Tanl volume: 20
```

**2. What is wrapper class in Java and Why we need wrapper class?**
Wrapper class is a class that provides an object representation for a primitive data type. 

Wrapper classes provide a way to work with primitive data types as objects, enable compatibility with generic classes and collections, and offer additional functionalities specific to each wrapper class.

**3. What is the difference between HashMap and HashTable?**
- Synchronization: 
HashTable is synchronized, which means it is thread-safe and can be used in multi-threaded environments without additional synchronization. On the other hand, HashMap is not synchronized by default.

- Null values and keys: 
HashTable does not allow null values or null keys. HashMap allows null values and a single null key. 

- Iteration: 
The iteration order of elements in HashMap is not guaranteed and may change over time, as it is based on the internal structure of the map. HashTable, however, iterates over elements in the same order they were inserted.

- Performance: 
HashMap generally provides better performance compared to HashTable. HashTable's synchronization comes with a performance cost, which can impact performance in highly concurrent applications.

**4. What is String pool in Java and why we need String pool?**
In Java, the string pool is a special area in memory where string literals are stored. The string pool is part of the Java Runtime Environment (JRE) and is used to optimize memory usage and improve performance when working with strings.

The main reasons why the string pool is used in Java are:
- Memory Efficiency:
Since string literals are immutable (cannot be changed), it is wasteful to create a new string object every time the same literal is used. By reusing existing strings from the pool, memory is conserved.

- Performance Optimization: 
Comparing strings for equality can be a costly operation. By reusing strings from the pool, Java can optimize string comparison by comparing the memory references instead of comparing the characters of each string.

- Constant Pool: 
The string pool is also part of the constant pool in Java, which is used for storing constants like numeric values, class and method names, and string literals. These constants can be easily referenced and accessed throughout the program.

**5. What is Java garbage collection?**
Java garbage collection is an automatic memory management function provided by Java virtual machine (JVM). It is responsible for reclaiming the memory that is no longer used by the program, freeing resources and preventing memory leak.

In Java, objects are dynamically allocated in heap memory, and programmers do not need to explicitly release memory when they are no longer needed. Garbage collector recognizes and releases the memory occupied by objects that are no longer accessible or referenced by the program.

The Java garbage collector operates by tracing the object graph from a set of root objects, such as Static variable, Local variable, and active threads. It explores all references from these root objects and marks accessible objects. Any object that is not marked as accessible is considered garbage.

**6. What are access modifiers and their scopes in Java?**
In Java, access modifiers are keywords that determine the accessibility or visibility of classes, methods, variables, and constructors within a program. They define the level of access that other parts of the program have to a particular element. There are four different access modifiers:

- Public: The public access modifier allows unrestricted access from anywhere in the program. Public elements can be accessed by any other class or package.

- Private: The private access modifier restricts access to the same class where the element is defined. Private elements are not accessible from outside the class in which they are declared, including subclasses and other classes in the same package.

- Protected: The protected access modifier allows access within the same package and from subclasses, even if they are in different packages. Protected elements are not accessible to unrelated classes in different packages.

- Default (No Modifier): If no access modifier is specified, the element has default accessibility, also known as package-private. Default elements are accessible within the same package but not from outside the package, even if they are in the same program.

It's important to note that classes and interfaces themselves can have either public or default access modifiers. Public classes/interfaces can be accessed from anywhere, while classes/interfaces with default access are accessible only within the same package.

**7. What is final key word? (Field, Method, Class)**
In programming, the "final" keyword is used to indicate that an entity (such as a variable, method, or class) cannot be modified or overridden. The specific behavior of the "final" keyword can vary depending on the context in which it is used:

- Final field is a variable whose value cannot be modified once it has been assigned. It is commonly used to represent constant values or to ensure immutability. Once a final field is assigned a value, it cannot be changed.

- Final Method: When applied to a method (a function inside a class), the "final" keyword prevents the method from being overridden by any subclass. In other words, the implementation of a final method cannot be changed in any subclass that inherits from the class where the method is defined.

- Final Class: When applied to a class, the "final" keyword prevents the class from being subclassed. It means that no other class can inherit from a final class. This is typically used when you want to ensure that a class's implementation or behavior should not be extended or modified.

By using the "final" keyword appropriately, you can add restrictions and enforce immutability or prevent modification of certain elements in your codebase.

**8. What is static keyword? (Field, Method, Class). When do we usually use it？**
The "static" keyword is used in programming languages like Java, C++, and C# to declare entities (fields, methods, or classes) that belong to the class itself rather than an instance of the class. Here's a breakdown of its usage for each entity:

- Static Field: A static field is a class-level variable that is shared among all instances of the class. 
- Static Method: A static method is a method that belongs to the class itself and can be called without creating an instance of the class.
- Static Class: A static class is a class that cannot be instantiated and can only contain static members, such as static fields and static methods. Static classes are typically used as containers for utility methods or as a way to organize related functions.

Overall, the "static" keyword is used when you want to associate a member (field or method) with the class itself, rather than with individual instances. It allows you to access these members without creating an object of the class, and they can be shared across multiple instances or called directly on the class.

**9. What is the differences between overriding and overloading?**
 Overriding is about providing a different implementation of a method in a subclass, while overloading is about defining multiple methods with the same name but different parameter lists within the same class or its subclasses.

**10. What is the differences between super and this?**
The "super" keyword is used to refer to the immediate parent class of a subclass. It is typically used to access members (variables or methods) of the superclass, especially when they are overridden in the subclass. 

The "this" keyword is used to refer to the current instance of a class. It is primarily used in instance methods and constructors to differentiate between instance variables and local variables or parameters that have the same name.

**11. What is the Java load sequence?**
In Java, the load sequence refers to the order in which classes are loaded and initialized during the execution of a Java program. The Java virtual machine (JVM) handles the class loading process based on certain rules and conditions. Here is a general overview of the Java class loading sequence:

- Loading: The class loading process begins when a Java program references a class for the first time. The JVM searches for the corresponding bytecode file (usually with a .class extension) in the classpath. If the class file is found, it is loaded into memory.
- Verification: After loading, the JVM performs a verification process to ensure the integrity and correctness of the bytecode. It checks for structural constraints, such as the validity of the class file format and proper linking to other classes.
- Preparation: In this step, the JVM allocates memory for static variables and initializes them with their default values. This includes static fields and variables declared with the "static" keyword.
- Resolution: During the resolution phase, the JVM resolves symbolic references to direct references. It involves linking the class to other classes or methods it references, determining the actual memory locations and methods to be invoked.
- Initialization: Once all the necessary classes have been loaded and resolved, the JVM proceeds with initializing the class. This step involves executing static initializers, which are blocks of code defined in the class and executed in the order they appear. Static initializers are used to initialize static variables or perform any necessary setup tasks.

**12. What is Polymorphism ? And how Java implements it?**
Polymorphism is a fundamental concept in object-oriented programming that allows objects of different classes to be treated as objects of a common superclass. It enables objects to be represented in multiple forms or types.

In Java, polymorphism is achieved through method overriding and inheritance. Here's how it works:
- Inheritance: Polymorphism relies on the concept of inheritance, where a subclass can inherit the properties and methods of its superclass. A subclass is a more specialized version of its superclass.
- Method Overriding: In Java, a subclass can provide its own implementation of a method that is already defined in its superclass. This is known as method overriding. The method in the subclass must have the same signature (method name and parameters) as the method in the superclass. By overriding methods, you can customize the behavior of an object based on its specific class.
- Dynamic Binding: Polymorphism is achieved at runtime through dynamic binding. This means that the specific implementation of a method is determined during runtime based on the actual type of the object rather than the reference type. When a method is invoked on an object, Java determines the appropriate implementation to execute based on the actual class of the object.

**13. What is Encapsulation ? How Java implements it? And why we need encapsulation?**
Encapsulation refers to the bundling of data and the methods that operate on that data into a single unit, called a class. It is a mechanism that allows for the hiding of internal data and implementation details of an object from the outside world.

In Java, encapsulation is implemented by:
- Access modifiers such as public, private, and protected. These modifiers control the visibility and accessibility of classes, variables, methods, and constructors.
- Getters and Setters: Encapsulated classes often provide public getter and setter methods to access and modify private data members. These methods allow controlled access to the internal state of an object, providing a level of abstraction and preventing direct manipulation of the data.

**14. What is Interface and what is abstract class? What are the differences between them?**
Both interfaces and abstract classes are used to define common behavior and establish contracts for classes that implement or inherit from them. However, there are some key differences between them.

An interface is a collection of abstract methods, which are method declarations without any implementation. It defines a set of methods that a class must implement. Interfaces can also include constants and default method implementations since Java 8. A class can implement multiple interfaces, allowing for multiple inheritance of behavior.

An abstract class, on the other hand, is a class that cannot be instantiated and is meant to be subclassed. It can contain both abstract and non-abstract methods. Abstract methods are declared without an implementation, similar to interface methods. Unlike interfaces, abstract classes can also have instance variables, constructors, and defined method implementations.

In general, if you need to define a contract for a group of classes or achieve multiple inheritance of type, interfaces are a good choice. If you want to provide a base implementation along with abstract methods, or if you want to define a common base for a group of related classes, abstract classes are more suitable.

**16. What are Queue interface implementations and what are the differences and when to use what?**
In Java, the Queue interface is a part of the java.util package and represents a collection of elements in a specific order. It follows the FIFO (First-In-First-Out) principle, where the elements are processed in the order they were added. There are several implementations of the Queue interface in Java, each with its own characteristics and best use cases.
- LinkedList: LinkedList is a doubly-linked list implementation of the Queue interface. It allows efficient insertion and deletion at both ends of the list, making it suitable for implementing a queue. It also provides additional methods for manipulating the elements in the list. LinkedList is a good choice when you need a simple, general-purpose queue implementation.

- PriorityQueue: PriorityQueue is an implementation of the Queue interface that provides ordering based on the natural order of the elements or a custom comparator. It maintains the elements in a partially ordered heap. The element with the highest priority (according to the specified ordering) is always at the front of the queue. PriorityQueue is useful when you need to process elements based on their priority.

- ArrayDeque: ArrayDeque is a resizable-array implementation of the Deque interface, which extends the Queue interface. It allows elements to be inserted and removed at both ends of the deque. ArrayDeque provides better performance than LinkedList in most cases and can be used as a general-purpose queue. It is a good choice when you need efficient insertion and removal operations from both ends.

- ConcurrentLinkedQueue: ConcurrentLinkedQueue is a concurrent implementation of the Queue interface, designed to be used in multithreaded environments. It provides thread-safe operations without the need for explicit synchronization. This implementation is suitable when you have multiple threads concurrently accessing and modifying the queue.
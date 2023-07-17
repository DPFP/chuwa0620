## 1. Write up Example code to demonstrate the three foundmental concepts of OOP.

* Encapsulation:

```java
public class Student {
    private String name;
    private String stu_id;

    public Student(String name, String stu_id) {
        this.name = name;
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void updateName(String newName) {
        name = newName;
    }

    public String getStu_id() {
        return stu_id;
    }
}
```

* Polymorphism:

```java
//Overriding
public class Shape {
    public double getArea() {
        return 0;
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

//Overloading
public class calculate {
    public static void main(String args[]) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

```

* Inheritance:

```java
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void printName() {
        System.out.println("Dog: " + name);
    }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?

A wrapper class is a class that provides an object representation for primitive data types. Wrapper classes in Java
bridge the gap between primitive types and objects, providing additional functionality and flexibility when working with
data. They enable us to treat primitive values as objects, facilitate conversions, and provide utility methods for
handling and manipulating primitive data in various contexts.

* Object Conversion: Wrapper classes allow us to convert between primitive types and objects. For example, when working
  with collections or APIs that require objects, we can wrap primitive values using the appropriate wrapper class.
* Nullable Values: Wrapper classes can handle null values. Unlike primitive types, which cannot hold null, wrapper
  classes can represent a missing or unknown value by assigning null to the object reference.
* Generics and Collections: Wrapper classes are commonly used in generics and collections. Generic types can only accept
  objects, so using wrapper classes allows us to work with primitive values in these contexts.
* Utility Methods: Wrapper classes provide useful methods for working with primitive values. For example, Integer class
  offers methods like parseInt() and toString(), which facilitate parsing strings to integers and converting integers to
  strings.
* Type Conversion: Wrapper classes provide methods to convert between different primitive types. For example, the
  Integer class provides methods like intValue(), doubleValue(), etc., which allow converting an Integer object to an
  int, double, and so on.
* Reflection: Wrapper classes are also used in reflection when we need to inspect the type of a field or method
  parameter. The wrapper classes provide methods to determine the wrapper class type.

## 3. What is the difference between HashMap and HashTable?

* Synchronization: HashTable is synchronized, which means it is thread-safe and can be accessed by multiple threads
  concurrently without the need for external synchronization. HashMap, on the other hand, is not synchronized by
  default. If thread safety is required when using HashMap, external synchronization mechanisms must be used.

* Nullability: HashTable does not allow null keys or null values. If a null key or value is attempted to be inserted, a
  NullPointerException is thrown. HashMap, on the other hand, allows null keys and values. You can store and retrieve
  null values in a HashMap without any exceptions.

* Performance: HashMap generally provides better performance compared to HashTable. HashTable's synchronized nature
  comes with an overhead, making it slower in single-threaded scenarios. HashMap is not burdened by the synchronization
  overhead, making it faster in most cases.

* Iterator: The iterator returned by HashTable is a legacy Enumeration, whereas HashMap's iterator is fail-fast and
  supports removal of elements during iteration.

## 4. What is String pool in Java and why we need String pool?

* In Java, the string pool is a special area of memory where String objects are stored
* It allows the JVM to avoid unnecessary object creation and promotes efficient memory utilization by reusing existing
  string instances. However, it's important to be cautious when working with string concatenation or creating strings
  dynamically, as it can lead to increased memory usage if not done carefully.

## 5. What is Java garbage collection?

Java garbage collection is an automatic memory management feature in the Java Virtual Machine (JVM) that automatically
reclaims memory occupied by objects that are no longer in use. It frees developers from manually deallocating memory and
helps prevent memory leaks and dangling references.

## 6. What are access modifiers and their scopes in Java?

Access modifiers in Java are keywords that define the accessibility or visibility of classes, methods, variables, or
constructors within a Java program.

* Public: The public access modifier provides the widest level of accessibility. Public members can be accessed from any
  other class or package. There is no restriction on their visibility.

* Private: The private access modifier restricts the accessibility of members to within the same class. Private members
  cannot be accessed or referenced from outside the class, including subclasses and other classes in the same package.

* Protected: The protected access modifier allows access to members within the same package and subclasses, even if they
  are in a different package. Protected members are not accessible to unrelated classes in different packages.

* Default (No Modifier): If no access modifier is specified, the member has default or package-private accessibility.
  Default members are accessible within the same package but not from outside the package, including subclasses in other
  packages.

## 7. What is final key word? (Filed, Method, Class)

* Final Fields: When a field is declared as final, its value cannot be changed once assigned. It acts as a constant or
  immutable variable. Final fields must be assigned a value either at the time of declaration or within the constructor.
* Final Methods: When a method is declared as final, it cannot be overridden by subclasses.
* Final Classes: When a class is declared as final, it cannot be subclassed or extended.

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

* Static Fields: When a field is declared as static, it is associated with the class itself rather than with individual
  objects or instances of the class. Static fields are shared among all instances of the class. There will be only one
  copy of the static field, regardless of how many objects of that class are created. Static fields are typically used
  for constants or shared data that needs to be accessible across instances of the class.
* Static Methods: When a method is declared as static, it belongs to the class rather than a specific instance. Static
  methods can be called directly on the class itself, without creating an object of the class. They can access only
  other static members (fields or methods) and cannot access instance-specific members.
* Static Nested Classes: When a nested class is declared as static, it is called a static nested class. Static nested
  classes are not associated with an instance of the enclosing class and can be instantiated without an instance of the
  enclosing class. They can be accessed using the enclosing class name.

Static elements are commonly used for constants, utility methods, shared data, or when there is no need for
object-specific behavior

## 9. What is the differences between overriding and overloading?

* Overriding: allows sub-class or child-class to provide a specific implementation for the method which is already
  provided by its super-class or parent-class. The methods must have the same name, same return type, and same
  parameters.
* Overloading: creating multiple methods with the same name in the same class, but with different parameters.

## 10. What is the differences between super and this?

super is used to access members of the superclass and invoke superclass constructors, while this is used to refer to the
current object and access instance members within the same class. super is associated with the inheritance hierarchy,
while this is used for self-reference within the current class.

## 11. What is the Java load sequence?

* Class Loading: When a Java program starts, the Java Virtual Machine (JVM) loads the required classes into memory.
  Classes are loaded on-demand as they are needed during the program's execution.

* Static Fields and Blocks: Once a class is loaded, static fields and static initialization blocks are executed. Static
  fields are initialized with their default values (0, false, or null) if not explicitly initialized. Static
  initialization blocks are executed in the order they appear in the code.

* Superclass Initialization: If the class being loaded extends another class, the superclass is initialized before the
  subclass. This process continues up the inheritance hierarchy until reaching the topmost superclass.

* Instance Fields and Blocks: When an object of a class is created, instance fields are initialized with their default
  values or values assigned during declaration. Instance initialization blocks, if present, are executed in the order
  they appear in the code. Finally, the constructor for the object is invoked.

## 12. What is Polymorphism ? And how Java implements it ?

Java implements polymorphism through method overrding and method overloading.

* In Java, Overriding is a feature that allows a subclass or child class to provide a specific implementation of a
  method that is already provided by one of its super-classes or parent classes. When a method in a subclass has the
  same name, the same parameters or signature, and the same return type(or sub-type) as a method in its super-class,
  then the method in the subclass is said to override the method in the super-class.
* With method overloading, multiple methods can have the same name with different parameters

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is a fundamental principle of object-oriented programming that involves bundling data (attributes) and
methods (behavior) together within a class and controlling their access through well-defined interfaces.

In Java, encapsulation is implemented using access modifiers (such as private, protected, and public) to control the
visibility of class members (fields, methods, and constructors).

Benefits of Encapsulation: Encapsulation is a key principle in object-oriented programming as it promotes data
integrity, abstraction, and code maintainability. It helps in building robust, secure, and reusable code by hiding the
internal implementation details of a class and providing controlled access to its data.

* Data Hiding: Encapsulation hides the internal implementation details of a class, allowing the class to change its
  internal state without affecting other code that uses the class.
* Abstraction: Encapsulation enables abstraction by exposing only the necessary information through well-defined
  interfaces (methods).

## 14. What is Interface and what is abstract class? What are the differences between them?

* Interface: An interface is a reference type that defines a contract of methods that a class implementing the interface
  must provide.
* Abstract class: An abstract class is a class that cannot be instantiated and serves as a base class for subclasses to
  extend and provide implementations for its abstract methods.

Differences:

* Interfaces are declared using the interface keyword. Classes can extend only one abstract class.
* All methods in an interface are implicitly public and abstract. Constants are public, static, and final by default.
  Abstract classes can have abstract methods (method signatures without implementations) as well as concrete methods (
  methods with implementations).
* Interfaces can't have instance variables (fields) or constructors. Abstract classes can have instance variables,
  constructors, and other non-abstract methods.
* Interfaces can be used to achieve multiple inheritance of types. Abstract classes are typically used to define common
  behavior and provide a base implementation that can be shared by multiple subclasses.

## 15.  (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )

If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT
just copy and paste)

## 16. What are Queue interface implementations and what are the differences and when to use what?

The Queue interface in Java represents a collection that follows the First-In-First-Out (FIFO) order.

* LinkedList: LinkedList implements both the List and Queue interfaces. LinkedList is a good choice when you need both
  queue and list functionality, and when frequent insertion and deletion operations are required.

* ArrayDeque: ArrayDeque is an implementation of the Deque interface, which extends the Queue interface. ArrayDeque is a
  good choice when you need a resizable queue and efficient insertion and removal at both ends.

* PriorityQueue: PriorityQueue is an implementation of the Queue interface that orders elements based on their natural
  order or a custom comparator. PriorityQueue is suitable when you need to process elements based on their priority,
  where the order of insertion is not important.
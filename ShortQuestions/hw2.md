## 1
# Encapsulation
Using setters and getters to obtain and modify fields in the class
instead of directly changing it.

```
public class Student {
    private String name;
    private int age;
    
    // Getter method for the name attribute
    public String getName() {
        return name;
    }
    
    // Setter method for the name attribute
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter method for the age attribute
    public int getAge() {
        return age;
    }
    
    // Setter method for the age attribute
    public void setAge(int age) {
        this.age = age;
    }
}
```

# Polymorphism
Polymorphism enables methods to be defined in a generic way, capable of performing different actions based on the type of object they are invoked on. 

```
class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat is meowing");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        
        animal1.makeSound();  // Output: Dog is barking
        animal2.makeSound();  // Output: Cat is meowing
    }
}

```

# Inheritance
Inheritance allows a class to inherit properties and behavior from another class.

```
class Vehicle {
    protected String brand;
    
    public void drive() {
        System.out.println("Driving the vehicle");
    }
}

class Car extends Vehicle {
    private int numberOfSeats;
    
    public Car(String brand, int numberOfSeats) {
        this.brand = brand;
        this.numberOfSeats = numberOfSeats;
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Number of seats: " + numberOfSeats);
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 5);
        car.displayInfo();  // Output: Brand: Toyota, Number of seats: 5
        car.drive();        // Output: Driving the vehicle
    }
}


```

## 2
In Java, a wrapper class is a class that provides an object representation of a primitive type. It allows the primitive types (such as int, char, boolean, etc.) to be treated as objects. We need wrapper class because it allows additional functionalities such as parsing, etc and it is more object-oriented compatible.

## 3
Both HashMap and HashTable are classes in Java that implement the Map interface and provide key-value pair storage. The key difference is that HashTable is thread safe whereas HashMap is not.

## 4
String pool is a special area in memory where string literals are stored. 
It decreases the number of string objects created in the memory so that it is beneficial in memory efficiency and performance optimization.

## 5
Java garbage collection is an automatic memory management mechanism provided by the Java Virtual Machine (JVM). It is responsible for reclaiming memory occupied by objects that are no longer referenced by the program, freeing up resources and preventing memory leaks.

## 6
- public

- private

- protected

- default

Public members can be accessed from any class or package without restrictions. Private modifier restricts the accessibility to within the same class. Protected modifier allows access within the same class, subclasses (even if they are in different packages), and other classes in the same package. Default members can be accessed within the same package but not from classes in different packages, even if they are subclasses.

## 7
final field: When applied to a field, the final keyword indicates that the field's value cannot be changed after initialization.

final method: When applied to a method, the final keyword indicates that the method cannot be overridden by subclasses. 

final class: When applied to a class, the final keyword indicates that the class cannot be subclassed.

## 8
When applied to a field, the static keyword makes the field belong to the class itself rather than individual instances of the class.

When applied to a method, the static keyword indicates that the method belongs to the class itself, rather than a specific instance of the class.

A static nested class is associated with the outer class, but it does not have access to the instance variables or methods of the outer class. 

- Creating shared data or constants that are common to all instances of a class.
- Defining utility methods or helper functions that don't rely on instance-specific data.
- Organizing related classes within a class hierarchy.
- Providing a way to access certain members without creating an instance of the class.

## 9
Overridden methods use dynamic binding, where the method implementation is resolved at runtime based on the actual object type.

Overloaded methods use static binding, where the method implementation is resolved at compile-time based on the method signature and arguments.

## 10
super is used to refer to the superclass or parent class of the current class and this is used to refer to the current class.

## 11
loading, linking, initialization

## 12
Polymorphism is a fundamental concept in object-oriented programming that allows objects of different types to be treated as objects of a common superclass type.

In Java, polymorphism is primarily achieved through two mechanisms:
Method Overriding and interface implementation.

## 13
Encapsulation is a fundamental concept in object-oriented programming that combines data and methods into a single unit called a class.

In Java, encapsulation is implemented using access modifiers and getter/setter methods to control the access to the class members (fields and methods). 

Encapsulation promotes data hiding, code maintainability, code reusability, and access control, making it an essential principle of object-oriented programming.

## 14
In Java, an interface and an abstract class are both used as mechanisms to define common behavior and provide a blueprint for classes to follow.

Differences:
- An interface cannot be instantiated, while an abstract class cannot be directly instantiated but can be subclassed.
- A class can implement multiple interfaces, but it can extend only one abstract class.
- An interface cannot have constructors, while an abstract class can have constructors that are called when a subclass is instantiated.
- Interface methods are implicitly public, while abstract class methods can have various access modifiers.


## 15
See answer in coding folder.

## 16
The Queue interface in Java represents a collection that is designed for holding elements in a specific order for processing. It follows the FIFO (First-In-First-Out) principle, where elements are added at the end and removed from the beginning.

- LinkedList
- ArrayDeque
- PriorityQueue
- BlockingQueue

Choosing the appropriate Queue implementation depends on the specific requirements and the characteristics need for the application. 


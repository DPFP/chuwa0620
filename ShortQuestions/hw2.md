# HW 2
## Q1 Example code
### Encapsulation
```
class Person {
    private String name;
    private int age;
 
    public String getName() { return name; }
 
    public void setName(String name) { this.name = name; }
 
    public int getAge() { return age; }
 
    public void setAge(int age) { this.age = age; }
}
```

## Polymorphism
### Static Polymorphism - Overload (same class) - compile time
```
class Helper {
 
    // Method 1
    // Multiplication of 2 numbers
    static int Multiply(int a, int b)
    {
 
        // Return product
        return a * b;
    }
 
    // Method 2
    // // Multiplication of 3 numbers
    static int Multiply(int a, int b, int c)
    {
 
        // Return product
        return a * b * c;
    }
}
 
```
### Dynamic Polymorphism - Override (child class) - run time
```
public class Shape {

    public double getArea() {
        return 0;
    }

}

// A Rectangle is a Shape with a specific width and height
class Rectangle extends Shape {   // extended form the Shape class

    private double width;
    private double height;

    public Rectangle(double width, double heigh) {
        this.width = width;
        this.height = heigh;
    }

    @Override
    public double getArea() {
        return width * height;
    }

}

// A Circle is a Shape with a specific radius
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

}
```

## Inheritance
```
class Animal{  
void eat(){System.out.println("eating...");}  
}  
class Dog extends Animal{  
void bark(){System.out.println("barking...");}  
}  
class BabyDog extends Dog{  
void weep(){System.out.println("weeping...");}  
}  
class TestInheritance2{  
public static void main(String args[]){  
BabyDog d=new BabyDog();  
d.weep();  
d.bark();  
d.eat();  
}}  
```

## Q2. What is wrapper class in Java and Why we need wrapper class?
```
Java wrapper classes represent or wrap the primitive data types’ values as an object. And theWrapper classes are useful 
for synchronization in multithreading. The synchronization process allows only one thread to use a shared resource at a
time. For that, wrapper class objects are required.
```

## Q3.  What is the difference between HashMap and HashTable?
```
HashMap can have one null key and multipul values while HashTable does not.
HashMap is not synchronoized, non-legacy, can be multithreded(so not thread-safe)
```

## Q4.  What is String pool in Java and why we need String pool?
```
String pool is a storage space in the Java heap memory where string literals are stored.
Java String Pool improves performance and reduces memory usage.
And it Provides reusability: It saves time to create a new string if there is already a 
string with the same value present in the pool.
```

## Q5.  What is Java garbage collection?
```
It is the automated process of deleting code that's no longer needed or used
```

## Q6.  What are access modifiers and their scopes in Java?
```
Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a 
class. The four access modifiers in Java are public, protected, default, and private.
Private: We can access the private modifier only within the same class and not from outside the class.
Default: We can access the default modifier only within the same package and not from outside the package.
Protected: We can access the protected modifier within the same package and also from outside the package with the help 
of the child class. 
Public: We can access the public modifier from anywhere.
```

## Q7.  What is final key word? (Filed, Method, Class)
```
Variable: If you make any variable as final, you cannot change the value of final variable
Method: If you make any method as final, you cannot override it. 
Class: If you make any class as final, you cannot extend it.
```

## Q8.  What is static keyword? (Filed, Method, Class). When do we usually use it?
```
The static keyword is used for a constant variable or a method that is the same for every instance of a class
And it applicable to: 
Blocks:If you need to do the computation in order to initialize your static variables, you can declare a static block 
that gets executed exactly once, when the class is first loaded. 
Variables: a single copy of the variable is created and shared among all objects at the class level
Methods: Methods have same property but with following restrictions:
--They can only directly call other static methods.
--They can only directly access static data.
--They cannot refer to this or super in any way.
Classes: A class can be made static only if it is a nested class
```

## Q9.  What is the differences between overriding and overloading
```
Runtime vs Compile time.
Same signiture vs Same name but different varable.
Occurs between superclass and subclass vs Occurs in the same class.
```

## Q10.  What is the differences between super and this?
```
Super: Immediate parent class
This: Curent class
```

## Q11.  What is the Java load sequence?
```
static -> non-static
Loading is the process of finding the binary representation of a class or interface type with a particular name and 
creating a class or interface from that binary representation.
```

## Q12.  What is Polymorphism ? And how Java implements it ?
```
Overiding and overwritting so that we can use many methods that are related to each other togather to perfom some tasks.
Examples in Q1.
```

## Q13.  What is Encapsulation ? How Java implements it? And why we need encapsulation?
```
Encapsulation in Java is the process by which data (variables) and the code that acts upon them (methods) are integrated
 as a single unit.
Examples in Q1.
Reasons: better control, security, flexibility. 
```

## Q14.  What is Interface and what is abstract class? What are the differences between them?
```
Interfaces are a kind of code contract, which must be implemented by a concrete class.
Abstract classes are similar to normal classes, with the difference that they can include abstract methods,
which are methods without a body. Abstract classes cannot be instantiated.
```

## Q15
```
See Coding/hw2_q15_parkinglot
// Reference from https://www.javatpoint.com/parking-lot-design-java
```

## Q16.  What are Queue interface implementations and what are the differences and when to use what?
```
The Queue interface is implemented by several classes in Java, including LinkedList, ArrayDeque, and PriorityQueue
Priority Queue will sort the element by the priority and the other two will have the FIFO order. And the deque can
operate fast from both end while linkedlist can only be fast out from front and add to the end.
```

## HW 2 design
```
See Coding/hw2_design_notification
```
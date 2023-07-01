#### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

1. Encapsulation;
2. Polymorphism;
3. Inheritance;

**Encapsulation:**

```java
public class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```



**Inheritance**

```Java
// Super class
public class Vehicle {
    public void startEngine() {
        System.out.println("Engine started.");
    }
}

// Subclass
public class Car extends Vehicle {
    public void honk() {
        System.out.println("Car honks.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Inheritance: Car inherits from Vehicle
        Car myCar = new Car();

        myCar.startEngine(); // method from Vehicle class
        myCar.honk(); // method from Car class
    }
}
```

**Polymorphism:**

```Java
// base class
public abstract class Animal {
    public abstract void sound();
}

// first subclass
public class Dog extends Animal {
    public void sound(){
        System.out.println("Dog barks");
    }
}

// second subclass
public class Cat extends Animal {
    public void sound(){
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        // Polymorphism: an Animal reference is used to refer to a Dog or Cat object
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.sound();
        myCat.sound();
    }
}
```

#### 2. What is wrapper class in Java and Why we need wrapper class?

- Wrapper classes in Java provide a way to wrap or represent the value of primitive data types as an object.  Sometimes you must use wrapper classes, for example when working with Collection objects, such as ArrayList, where primitive types cannot be used (the list can only store objects):

```java
ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid
ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid
```

| Primitive Data Type | Wrapper Class |
| :-----------------: | :-----------: |
|        char         |   Character   |
|        byte         |     Byte      |
|        short        |     Short     |
|         int         |    Integer    |
|        long         |     Long      |
|        float        |     Float     |
|       double        |    Double     |
|       boolean       |    Boolean    |



#### 3. What is the difference between HashMap and HashTable?

| S. No. |                           Hashmap                            |                          Hashtable                           |
| :----: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|   1.   |                  No method is synchronized.                  |                Every method is synchronized.                 |
|   2.   | Multiple threads can operate simultaneously and hence hashmap’s object is **not thread-safe**. | At a time only one thread is allowed to operate the Hashtable’s object. Hence it is **thread-safe**. |
|   3.   | Threads are not required to wait and hence relatively performance is high. | It increases the waiting time of the thread and hence performance is low. |
|   4.   |           Null is allowed for both key and value.            | Null is not allowed for both key and value. Otherwise, we will get a null pointer exception. |

#### 4. What is String pool in Java and why we need String pool?

- String Pool in Java is a pool of Strings stored in Java Heap Memory.
- It is created **to decrease the number of string objects created in the memory**. Whenever a new string is created, JVM first checks the string pool. If it encounters the same string, then instead of creating a new string, it returns a reference existing string to the variable.

#### 5. What is Java garbage collection?

Java Garbage Collection (GC) is a part of Java's memory management system that automatically identifies and deallocates objects that are no longer in use by the program, freeing up memory for new objects.

#### 6. What are access modifiers and their scopes in Java?

Access modifiers are **keywords that can be used to control the visibility of fields, methods, and constructors in a class**. The four access modifiers in Java are **public, protected, default, and private.**

| Default   | declarations are visible only within the package (package private) |
| --------- | ------------------------------------------------------------ |
| Private   | declarations are visible within the class only               |
| Protected | declarations are visible within the package or all subclasses |
| Public    | declarations are visible everywhere                          |

#### 7. What is final key word? (Field, Method, Class)

**Final Variable**: If you make any variable as final, you cannot change the value of the final variable (It will be constant). For example:

```Java
final int MAX_VALUE = 99;
```

**Final Method**: If you make any method as final, you cannot override it

The `run()` method cannot be overridden in any class that extends `Vehicle`.

```Java
public class Vehicle {
    final void run() {
        System.out.println("Vehicle is running");
    }
}
```

**Final Class**: If you make any class as final, you cannot extend it. This means that the final class can't be a superclass

No class can extend the `Vehicle` class in this case.

```Java
final class Vehicle {
    // class methods and variables
}
```



#### 8. What is static keyword? (Field, Method, Class). When do we usually use it?

**Static Variable**: The static variable can be used to refer to the common property of all objects (that is not unique for each object), e.g., the company name of employees, college name of students, etc. 

```Java
class Employee {
    static String company = "OpenAI"; // static variable  
}
```

**Static Method**: A static method belongs to the class rather than the instance of a class. The static method can be invoked without the need for creating an instance of a class. Static methods can only access static data (instance variables). They can not access non-static data (instance variables) and call non-static methods directly.

```Java
class MathUtils {
    static int add(int x, int y) {  // static method
        return x + y;
    }
}
// Can be called as MathUtils.add(5, 6);
```

**Static Class**: In Java, we can't use the static keyword with a top-level class. We can only use the static keyword with nested classes. A static nested class is a nested class that is a static member of the outer class. 

```Java
class OuterClass {
    static class StaticNestedClass {
        // members
    }
}
```

**Static Block**: Static block is used for initializing the static variables. This block gets executed when the class is loaded in the memory.

```Java
class MyStaticBlock {
    static int num;
    static String str;
    static {  // static block
        num = 97;
        str = "Static keyword in Java";
    }
}

```

We usually use the `static` keyword:

- When we need a variable to be common to all instances of that class and accessible even without an instance of the class.
- When we need to use a method which doesn't need any instance variables.
- When we need a utility function that shouldn't change its behavior regardless of any state. For example, a mathematical calculation or string manipulation.
- When we want to encapsulate helper classes or interfaces that don't require instantiation

#### 9. What is the differences between overriding and overloading?

| Method Overloading                                           | Method Overriding                                            |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Overloading happens at compile time.                         | Overriding happens at runtime.                               |
| Gives better performance because the binding is being done at compile time. | Gives less performance because the binding is being done at run time. |
| Private and final methods can be overloaded.                 | Private and final methods can NOT be overridden.             |
| Return type of method does not matter in case of method overloading. | Return type of method must be the same in the case of overriding. |
| Arguments must be different in the case of overloading.      | Arguments must be the same in the case of overriding.        |
| It is being done in the same class.                          | Base and derived(child) classes are required here.           |
| Mostly used to increase the readability of the code.         | Mostly used to provide the implementation of the method that is already provided by its base class. |

```Java
public class MyClass {

    // Method overloading: same method name, different parameters
    void myMethod(int num) {
        System.out.println("Integer:" + num);
    }

    void myMethod(String str) {
        System.out.println("String:" + str);
    }

}

public class MySubClass extends MyClass {

    // Method overriding: same method name, same parameters as in parent class
    @Override
    void myMethod(int num) {
        System.out.println("Overridden Integer:" + num);
    }

}

```



#### 10. What is the differences between super and this?

In Java, super keyword is used to access methods of the parent class while this is used to access methods of the current class. 

```Java
// Java Program to illustrate using this
// many number of times
 
class RRR {
    // instance variable
    int a = 10;
 
    // static variable
    static int b = 20;
 
    void GFG()
    {
        // referring current class(i.e, class RR)
        // instance variable(i.e, a)
        this.a = 100;
 
        System.out.println(a);
 
        // referring current class(i.e, class RR)
        // static variable(i.e, b)
        this.b = 600;
 
        System.out.println(b);
 
        // referring current class(i.e, class RR)
        // instance variable(i.e, a) again
        this.a = 9000;
 
        System.out.println(a);
    }
 
    public static void main(String[] args)
    {
        new RRR().GFG();
    }
}


100
600
9000
```

```Java
// Java Program to illustrate using super
// many number of times
 
class Parent {
    // instance variable
    int a = 36;
 
    // static variable
    static float x = 12.2f;
}
 
class Base extends Parent {
    void GFG()
    {
        // referring super class(i.e, class Parent)
        // instance variable(i.e, a)
        super.a = 1;
        System.out.println(a);
 
        // referring super class(i.e, class Parent)
        // static variable(i.e, x)
        super.x = 60.3f;
 
        System.out.println(x);
    }
    public static void main(String[] args)
    {
        new Base().GFG();
    }
}

1
60.3
```



#### 11. What is the Java load sequence?

static variable/block -> constructor(used in Obj)

#### 12. What is Polymorphism ? And how Java implements it ?

- polymorphism refers to the same object exhibiting different forms and behaviors.
- Method Overloading and Method Overriding

#### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

- Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a
  single unit (class).
- Encapsulation can be achieved by Declaring all the variables in the class as private and writing public methods in the class to set and get the values of variables. 
- It prevents outer classes from accessing and changing fields and methods of a class. This also helps to achieve data hiding.

#### 14. What is Interface and what is abstract class? What are the differences between them?

```Java
Abstract class example:

abstract class Shape {
    int b = 20;
    abstract public void calculateArea();
}

public class Rectangle extends Shape {
    public static void main(String args[]) {
        Rectangle obj = new Rectangle();
        obj.b = 200;
        obj.calculateArea();
    }
    public void calculateArea() {
        System.out.println("Area is " + (b * b));
    }
}
```



#### 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )

If you have no ability to design it, please find the solution in internet, then understand it, and re-type
it.(Do NOT just copy and paste)





#### 16. What are Queue interface implementations and what are the differences and when to use what?

- The Queue interface is implemented by several classes in Java, including **LinkedList, ArrayDeque, and PriorityQueue**. Each of these classes provides different implementations of the queue interface, with different performance characteristics and features.
- LinkedList is based on a linked list and is suitable for scenarios that require frequent insertion at the end and removal from the front of the queue.
- ArrayDeque is based on an array and supports insertion and deletion operations at both ends of the queue, making it suitable for scenarios that require operations at both ends.
- PriorityQueue is based on a priority heap and is suitable for scenarios that require processing elements in priority order.
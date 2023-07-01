### HW2

1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo
   repo as example)

   1. Encapsulation:

   ```
   public class Car {
    private String model;
    private int year;
    private double price;

    // 构造方法
    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // 获取车辆型号
    public String getModel() {
        return model;
    }

    // 设置车辆型号
    public void setModel(String model) {
        this.model = model;
    }

    // 获取车辆年份
    public int getYear() {
        return year;
    }

    // 设置车辆年份
    public void setYear(int year) {
        this.year = year;
    }

    // 获取车辆价格
    public double getPrice() {
        return price;
    }

    // 设置车辆价格
    public void setPrice(double price) {
        this.price = price;
    }
   }
   ```

   2. Polymorphism

   ```
    abstract class Shape {
        public abstract void draw();
    }

    class Circle extends Shape {
        public void draw() {
            System.out.println("Drawing a circle");
        }
    }

    class Rectangle extends Shape {
        public void draw() {
            System.out.println("Drawing a rectangle");
        }
    }
   ```

   3. Inheritance

   ```
    class Animal {
    private String name;

        public Animal(String name) {
            this.name = name;
        }

        public void eat() {
            System.out.println(name + " is eating");
        }

        public void sleep() {
            System.out.println(name + " is sleeping");
        }
    }

    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        public void bark() {
            System.out.println("Dog is barking");
        }
    }

    class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        public void meow() {
            System.out.println("Cat is meowing");
        }
    }

   ```

2. What is wrapper class in Java and Why we need wrapper class?
   In Java, a wrapper class is a class that provides an object representation of a primitive data type. Each primitive data type in Java has a corresponding wrapper class, which allows the primitive values to be used as objects.

   - Wrapper classes provide a way to use primitive values as objects, enabling their use in object-oriented programming paradigms.
   - Wrapper classes allow us to use primitive types as generic type arguments. For example, `ArrayList<Integer>` can store a list of Integer objects, but not a list of int values. However, we can use the Integer wrapper class to achieve this.
   - Wrapper classes provide a way to represent null values for primitive types. For example, Integer can be null, while int cannot.

3. What is the difference between HashMap and HashTable?
   - HashTable is synchronized, which means it is thread-safe and can be accessed by multiple threads concurrently without external synchronization. On the other hand, HashMap is not synchronized by default, so if multiple threads access a HashMap concurrently, external synchronization is required to ensure thread safety.
   - HashTable does not allow null keys or values. If you attempt to store a null key or value, a NullPointerException will be thrown. In contrast, HashMap allows a null value and a null key. You can have at most one null key and multiple null values in a HashMap.
   - HashMap generally offers better performance compared to HashTable. Since HashMap is not synchronized, it avoids the overhead of synchronization, making it faster in single-threaded scenarios. However, in highly concurrent scenarios, where multiple threads need to access and modify the map concurrently, HashTable's synchronization can provide better thread safety.
4. What is String pool in Java and why we need String pool?
   In Java, the String pool is a special memory area that stores string objects. Its main purpose is to improve memory utilization and performance by sharing string objects when needed.
   When a string is created, the Java compiler first checks if an identical string object already exists in the string pool. If it exists, the compiler returns a reference to that existing object instead of creating a new string object. This helps to avoid the creation of duplicate string objects and saves memory space.
5. What is Java garbage collection?
   Java garbage collection is a process that automatically manages the memory in Java programs. It refers to the automatic reclamation of memory occupied by objects that are no longer in use, freeing up resources and ensuring efficient memory utilization.
6. What are access modifiers and their scopes in Java?
   In Java, access modifiers are keywords used to control the accessibility of classes, methods, variables, and constructors. Java provides four different access modifiers, each with its own scope and visibility.

   Here are the access modifiers in Java and their scopes:

   - public: The public access modifier has the widest accessibility and can be accessed from anywhere. Its scope is the entire program, including other classes, packages, and modules.

   - protected: The protected access modifier allows access within the current class, other classes in the same package, and subclasses of that class. It provides package-level access and inheritance-level access.

   - default (package-private): If no access modifier is specified, i.e., no public, protected, or private modifier is used, the member will have the default access modifier. It is restricted to access within the same package.

   - private: The private access modifier provides the strictest access restriction. It allows access only within the current class. Other classes, including those in the same package and subclasses, cannot directly access private members.

7. What is final key word? (Filed, Method, Class)
   In Java, the "final" keyword can be applied to fields, methods, and classes, and its meaning and usage differ based on where it is used.

   - Final Fields:
     When applied to a field, the "final" keyword indicates that the field's value cannot be changed once it has been assigned. It essentially makes the field a constant. Final fields must be assigned a value either during their declaration or within the constructor of the class. Once assigned, their value remains constant throughout the object's lifetime.

   - Final Methods:
     When applied to a method, the "final" keyword indicates that the method cannot be overridden by any subclass. It prevents subclasses from providing a different implementation of the method. This is useful when you want to ensure that a method's behavior remains consistent and cannot be modified by subclasses.

   - Final Classes:
     When applied to a class, the "final" keyword indicates that the class cannot be subclassed. It prevents other classes from extending or inheriting from the final class. This is useful when you want to prevent any further extension or modification of a class.

8. What is static keyword? (Filed, Method, Class). When do we usually use it?
   Static Fields:
   When applied to a field, the "static" keyword indicates that the field belongs to the class rather than to instances of the class. Static fields have only one copy in memory, regardless of how many objects are created. They are accessed directly using the class name, without needing to create an instance.

   - Static Methods:
     When applied to a method, the "static" keyword indicates that the method belongs to the class rather than to instances of the class. Static methods can be called directly using the class name, without needing to create an instance. They are often used to perform operations that are related to the class itself, rather than relying on the state of specific objects.

   - Static Classes:
     In Java, there is no direct keyword to define static classes. The term "static class" usually refers to a class with static members (fields and methods) that cannot be instantiated. By making all members static, the effect of a static class can be achieved.

   We usually use the "static" keyword in the following situations:

   - Counters or identifiers: Static fields can be used to share the same counter or identifier among multiple objects, to track the number or status of objects.
   - Utility classes: Static methods and static fields are used to create utility classes that provide commonly used functionality or algorithms without needing to instantiate objects.
   - Constant definitions: Static fields are used to define constants that can be accessed directly using the class name from anywhere in the program.
   - Singleton pattern: By making the constructor private and providing a static method to obtain a single instance of the class, the singleton pattern can be implemented.

9. What is the differences between overriding and overloading?
   Overriding occurs when a subclass provides its own implementation of a method inherited from its superclass, while overloading occurs when multiple methods with the same name but different parameters are defined within the same class.
10. What is the differences between super and this?
    Super is the parent of current class, while this is the current class.
11. What is the Java load sequence?
    The Java load sequence refers to the order in which static fields, static blocks, superclass initialization, class initialization, instance fields, instance blocks, and constructors are executed during the initialization and instantiation of classes and objects.
12. What is Polymorphism ? And how Java implements it ?
    Polymorphism in Java refers to the ability of objects of different classes to be treated as objects of a common superclass, allowing for dynamic method dispatch and runtime method binding. Java implements polymorphism through method overriding, where a subclass provides its own implementation of a method defined in its superclass, and through interfaces, which define a contract for classes to implement common methods.
13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
    Encapsulation is a principle in object-oriented programming that combines data and methods into a single unit, known as a class, and restricts direct access to the data by providing controlled access through methods. In Java, encapsulation is implemented using access modifiers (such as private, public, protected) to control the visibility of class members (fields and methods), and by using getter and setter methods to provide controlled access to the data.
    Encapsulation in Java helps in achieving data abstraction, data hiding, code organization, and code maintainability, promoting better software design and development practices.
14. What is Interface and what is abstract class? What are the differences between them?
    Interfaces in Java are collections of abstract methods and constant fields that define a contract for classes to implement, focusing on achieving full abstraction. Abstract classes, on the other hand, are classes that cannot be instantiated and provide a partial implementation with both abstract and concrete methods, serving as a base for subclasses. The key differences include the ability to implement multiple interfaces but extend only one abstract class, the presence of instance fields in abstract classes, and their respective purposes in code design and reuse.
15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )
16. If you have no ability to design it, please find the solution in internet, then understand it, and re-type
    it.(Do NOT just copy and paste)
17. What are Queue interface implementations and what are the differences and when to use what?
    In Java, there are several implementations of the Queue interface, each with its own characteristics:

    - LinkedList: It is a doubly-linked list implementation that allows elements to be added or removed from both ends of the list. It is suitable for implementing a FIFO queue or a double-ended queue (deque).

    - ArrayDeque: It is a resizable array implementation of the Deque interface that provides efficient element insertion and removal at both ends. It is suitable for implementing a queue or a deque with efficient operations at both ends.

    - PriorityQueue: It is an implementation of the Queue interface that orders elements based on their priority. Elements are ordered according to their natural order or a custom comparator. It is suitable for implementing a priority-based queue.

    The choice of which implementation to use depends on the specific requirements of your application. LinkedList or ArrayDeque can be used for a basic FIFO queue or a double-ended queue. PriorityQueue is suitable when elements need to be ordered by priority. Consider factors such as the required operations, ordering requirements, and performance characteristics to determine the most appropriate implementation for your use case.

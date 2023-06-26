# HW2

## Q1: Write up Example code to demonstrate the three foundmental concepts of OOP.


## Q2: What is wrapper class in Java and Why do we need wrapper class?

Wrapper class: wrap primitive type values to objects. <br>
Wrapper classes allow **object-oriented programming** on primitive type values as some data structures in Java only support Objects.<br>
Also, wrapper classes allow **null value** while primitive type doesn't allow.<br>
Wrapper classes are immutable and thus they can be used in **multi-threading environments**. <br>

## Q3: What is the difference between HashMap and HashTable?

1. **Synchronization**: HashMap is not synchronized and thus it cannot be used in multi-threading environment. Hashtable is synchronized.
2. **Performance**: The performance of HashMap is faster than HashTable, as HashMap does not need synchronization.
3. **Null value**: HashMap allows `null` value, while HashTable does not allow `null` value. 


## Q4: What is String pool in Java and why do we need String pool?

String pool is a special area in Heap memory where Java stores all the String literals you created. <br>
The advantages of using Java String pool:<br>
1. **Avoid duplicate Strings** -> **Heap memory optimization**
   When you create a String object using a string literal (like String s = "Hello"), the JVM first checks the String pool. <br>
   If the string "Hello" already exists in the pool, the JVM just returns a reference to the pooled instance. <br>
   If the string doesn't exist, it's added to the pool, and its reference is returned. <br>
   Thus, this reduces duplicate String object creation in heap and thus improves heap memory optimization.
   

## Q5: What is Java garbage collection?

In Java, garbage collection is a form of automatic memory management. <br>
JVM will view objects regularly to identify objects that are no longer in use by your application and deallocates their memory. <br>

## Q6: What are access modifiers and their scopes in Java?
        `private`: only methods and variables inside the same class can access it.<br>
        `default`: only visible to within the same package, but not to subclasses in other packages.<br>
        `protected`: visible to all classes in the same package and subclasses in other packages.<br>
        `public`: visible to all classes in all packages<br>


## Q7: What is `final` keyword? (Variable, Method, Class)

1. **variable**: `final` variable is immutable.
2. **methods**: `final` method cannot be overridden by subclasses.
3. **class**: `final` class cannot be extended.

## Q8. What is `static` keyword? (Variable, Method, Class). When do we usually use it?

1. **variable**: `static` variables belong to the class, each class only has one static variable instance. <br>
2. **method**: `static` methods also belong to the class. Besides, it can only use other static variable and methods in the same class.
3. **class**: In Java, we can have `static` inner classes. `static` inner classes can be accessed without instantiating the outer class, like static methods. A static inner class can access static data members of the outer class, but it cannot access non-static members.  <br>

When we usually use `static` keyword: when we need some data or methods to be available at the class level, i.e., independent of any particular object instance of that class.

## Q9. What are the differences between overriding and overloading?
`overloading`: Subclass can replace the method implementation of a method with the same method name and the same number of parameters. <br>
`overriding`: allowing multiple methods with the same name in the same class with different types, numbers, or the order of parameters <br>

## Q10. What are the differences between super and this?
`super`: refers to the parent class.<br>
`this`: refers to the current class.<br>

## Q11. What is the Java load sequence?

Load Sequence:
1. **Loading of Classes**: The loading process includes locating the class file (through the classpath), reading the class file into memory, and parsing the class file format to create an internal representation. Performed by ClassLoader,
2. **Linking**: the process of taking the class files and combining them into the runtime state of the application. This involves three stages: verification (checking the format and dependencies), preparation (allocating memory for class variables and initializing them to default values), and resolution (replacing symbolic references in the type with direct references).
3. **Initialization**: the execution of `static` initializers and initializations of `static` fields (in textual order), from top to bottom in the order they appear in the program.
4. **Creating Objects**: When you create an object using the `new` keyword, memory is allocated on the heap and the constructor is called.
5. **Accessing methods and other fields**: After all the loading, linking, and initialization has been done, the JVM accesses the fields and methods of the loaded classes.


## Q12. What is Polymorphism? And how Java implements it?

Polymorphism allows you to write code that treats an object according to the way it behaves, rather than what it is. <br>
This facilitates flexibility and extensibility in code and allows you to extend functionality by adding new classes and methods that conform to existing interfaces. <br>
Java implements it in two ways:
1. **Runtime Polymorphism**: <br>
  It is method overriding, where a subclass provides a specific implementation for a method that is already provided by its parent class.
2. **Compile time Polymorphism**: <br>
  method overloading, where multiple methods have the same name but different parameters (in type, number, or order). The compiler determines which method to call based on the method signature.
   

### Q13. What is Encapsulation? How Java implements it? And why do we need encapsulation?

Encapsulation refers to data hiding. Java implements it by using `private` access modifiers and different layers of classes. <br>
The advantages of encapsulation:
1. **Control Over Data**: can add conditions and checks before setting data.
2. **Data hiding**: The user can use the getters and setters without needing to understand how they're implemented.
3. **Protecting Integrity of Data**: protect an object's internal state from corruption by preventing unauthorized access.

### Q14. What is Interface and what is an abstract class? What are the differences between them?
`interface`: It provides total abstraction; it can have only abstract methods or default methods and final/constant variables. It's used to specify what a class should do but not how it should do it. <br>
`abstract` class: It acts as a base class for all classes. <br>
Differences: <br>
1. **Type of methods**: abstract class can have both abstract and non-abstract methods while interface can have only abstract methods.
2. **Fields**: Variables declared in a Java interface are by default final (constant). An abstract class may contain non-final variables.
3. **Implementation**: An interface provides a way to ensure that a class performs certain behavior; an abstract class provides a way to achieve partial implementation of functionality that can be shared across subclasses.
4. **inheritance**: A class can implement multiple interfaces but can inherit from only one abstract class.


### Q15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder)
        1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type
        it.(Do NOT just copy and paste)


### Q16. What are Queue interface implementations and what are the differences and when to use what?
1. `LinkedList`: Need LIFO behavior.
2. `PriorityQueue`: Need to take elements according to their natural order or custom order.

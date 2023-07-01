### 2 What is the checked exception and unchecked exception in Java, could you give one example?
checked exception: These are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword.  

unchecked exception: These are the exceptions that are not checked at compile time. In Java, exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked.   

### 3 Can there be multiple finally blocks?
There can only be one finally block, and it must follow the catch blocks. If the try block exits normally (no exceptions occurred), then control goes directly to the finally block. After the finally block is executed, the statements following it get control.

### 4 When both catch and finally return values, what will be the final result?
If both catch and finally return, the receiving method will get the returned value from the finally block.


### 5 What is Runtime/unchecked exception? what is Compile/Checked Exception?
Runtime Exceptions are not caught at the time of compiling the program.  
The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur. Unlike exceptions that are not considered as Runtime Exceptions, Runtime Exceptions are never checked.  

Comiple Exceptions are reported and handled at the time of compiling the program.  
The Compile Exceptions are checked by the compiler during the compilation process to confirm whether the exception is handled by the programmer or not. If not, then the system displays a compilation error.

### 6 What is the difference between throw and throws?
The throw keyword is used inside a function. It is used when it is required to throw an Exception logically. The throws keyword is used in the function signature. It is used when the function has some statements that can lead to exceptions.  

### 7 Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
We need to excute the catch expections from narrow to abroad. Because Null/Runtime exception is the subclass exception, it need to be put before Exception.

### 8 Why finally always be executed?
If an exception occurs like closing a file or DB connection, then the finally block is used to clean up the code.

### 9 What are the types of design patterns in Java?
1. Creational Design Pattern:
Factory Pattern, 
Abstract Factory Pattern, 
Singleton Pattern, 
Prototype Pattern, 
Builder Pattern
2. Structural Design Pattern: 
Adapter Pattern, 
Bridge Pattern, 
Composite Pattern, 
Decorator Pattern, 
Facade Pattern, 
Flyweight Pattern, 
Proxy Pattern
3. Behavioral Design Pattern: 
Chain Of Responsibility Pattern, 
Command Pattern, 
Interpreter Pattern, 
Iterator Pattern, 
Mediator Pattern, 
Memento Pattern, 
Observer Pattern, 
State Pattern, 
Strategy Pattern, 
Template Pattern, 
Visitor Pattern

### 10 What are the SOLID Principles?
Single Responsibility Principle (SRP): A class should have only one reason to change, meaning it should have a single responsibility.  
Open-Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.  
Liskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.  
Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. Split large interfaces into smaller and more specific ones.  
Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details, but details should depend on abstractions.

### 11 How can you achieve thread-safe singleton patterns in Java？
1. Eager load
```
public class GFG
{
  private static final GFG instance = new GFG();
 
  private GFG(){
  }
  public static GFG getInstance(){
        return instance;
    }
}
```

2. lazy load
```
public class GFG
{
  private static GFG instance;
 
  private GFG(){
  }
 
  public static GFG getInstance()
  {
    if (instance == null)
    {
      instance = new GFG();
    }
    return instance;
  }
}
```

### 12 What do you understand by the Open-Closed Principle (OCP)?
Open/closed principle is intended to mitigate risk when introducing new functionality. Since you don't modify existing code you can be assured that it wouldn't be broken. It reduces maintenance cost and increases product stability.

### 13 Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean?
The answer is 1. The object of type B should be able to perform all the functions that the object of type A can perform.

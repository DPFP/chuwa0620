# HW3
**2. What is the checked exception and unchecked exception in Java, could you give one example?**
- Checked Exceptions:
Checked exceptions are exceptions that the compiler requires you to handle explicitly. When a method throws a checked exception, the caller must either handle the exception using a try-catch block or declare the exception to be thrown by the method using the "throws" keyword. Example of a checked exception: IOException

- Unchecked Exceptions:
Unchecked exceptions, also known as runtime exceptions, are exceptions that are not required to be caught or declared explicitly. They usually occur due to programming errors such as null pointer dereference or array index out of bounds.
Example of an unchecked exception: NullPointerException

**3. Can there be multiple finally blocks?**
No. In Java, there can only be one finally block associated with a try block. The finally block is used to specify a block of code that will always be executed, regardless of whether an exception is thrown or not. It is typically used to release resources or perform cleanup operations.

**4. When both catch and finally return values, what will be the final result?**
If both the catch block and the finally block return values, the value returned by the finally block will be the final result.

**5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?**
- Checked Exceptions (Compile-Time Exceptions):
Checked exceptions are exceptions that the compiler requires you to handle explicitly. These exceptions are checked at compile time to ensure that they are properly handled. If you use a method that throws a checked exception, you must either catch and handle the exception or declare that your method also throws the exception. Examples of checked exceptions in Java include IOException, SQLException, and ClassNotFoundException.

- Unchecked Exceptions (Runtime Exceptions):
Unchecked exceptions, also known as runtime exceptions, are exceptions that do not need to be declared explicitly or caught by the compiler. These exceptions can occur at runtime and are not checked by the compiler. Unchecked exceptions usually indicate programming errors or unexpected conditions that may occur during the execution of a program. Unlike checked exceptions, you are not required to handle or declare unchecked exceptions explicitly. Some common examples of unchecked exceptions in Java include NullPointerException, ArrayIndexOutOfBoundsException, and IllegalArgumentException.

To summarize, checked exceptions are checked at compile time and require explicit handling or declaration.
Unchecked exceptions (runtime exceptions) are not checked at compile time and do not require explicit handling or declaration.

**6. What is the difference between throw and throws**
- throw is a keyword used to explicitly throw an exception in Java.
It is followed by an instance of an exception class or a subclass of Throwable. When the throw statement is executed, it causes the program to immediately stop the current execution and transfer the control to an appropriate exception handler. The throw statement is typically used inside methods or blocks to indicate that an exceptional condition has occurred and needs to be handled.
  
- throws is a keyword used in a method declaration to specify the exceptions that might be thrown by that method.
It is followed by a list of exception classes separated by commas. When a method declares that it throws an exception, it is indicating that the method may raise an exception during its execution, and the responsibility of handling that exception is delegated to the caller of the method. The caller must either catch the exception using a try-catch block or declare that it throws the exception as well.

**7. Run the below three pieces codes, Noticed the printed exceptions. Why do we put the Null/Runtime exception before Exception**
By convention, it's generally recommended to catch and handle exceptions from most specific to least specific. The rationale behind this convention is to ensure that more specific exceptions are caught and handled before more general exceptions. This approach allows for more precise error handling and can help with debugging and troubleshooting.

Since NullPointerException is a more specific exception than Exception, it is placed before the Exception catch block. If the Exception catch block were placed first, it would catch all exceptions, including NullPointerException, and the specific handling for NullPointerException would never be reached.

**7. Why finally always be executed**
The main purpose of the finally block is to perform cleanup tasks or release resources that were acquired in the try block, regardless of whether an exception was thrown or caught. It ensures that the cleanup code is executed even if an exception is thrown and not explicitly caught by the catch block.

**8. What are the types of design patterns in Java？**
1. Creational Patterns:
- Singleton: Ensures only one instance of a class is created.
- Factory Method: Creates objects without specifying their exact class.
- Abstract Factory: Provides an interface for creating related or dependent objects.
- Builder: Constructs complex objects step by step.
- Prototype: Creates new objects by cloning existing ones.
2. Structural Patterns:
- Adapter: Allows objects with incompatible interfaces to work together.
- Decorator: Adds behavior or responsibilities to objects dynamically.
- Composite: Composes objects into tree structures to represent part-whole hierarchies.
- Facade: Provides a simplified interface to a complex subsystem.
- Proxy: Controls access to objects by providing a surrogate or placeholder.

3.Behavioral Patterns:
- Observer: Defines a one-to-many dependency between objects, so that when one object changes state, all its dependents are notified.
- Strategy: Encapsulates interchangeable algorithms and lets them be used interchangeably within a context.
- Iterator: Provides a way to access elements of an aggregate object sequentially without exposing its underlying representation.
- Template Method: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
- Command: Encapsulates a request as an object, allowing parameterization and queuing of requests.

**9. What are the SOLID Principles ?**
- Single Responsibility Principle (SRP): A class should have only one reason to change. It means that a class should have a single responsibility or job and should not be responsible for multiple unrelated tasks.

- Open/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. In other words, you should be able to add new functionality without modifying existing code.

- Liskov Substitution Principle (LSP): Subtypes should be substitutable for their base types. This principle ensures that objects of a superclass can be replaced with objects of its subclass without affecting the correctness of the program.

- Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. It suggests that classes should have specific interfaces tailored to their needs rather than a single interface that provides more than what they require.

- Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions. This principle promotes loose coupling and allows for easier changes and testing of code.

These principles work together to create code that is modular, flexible, and easier to maintain. By following SOLID principles, you can enhance code quality, improve code reusability, and make your software more resilient to changes and evolving requirements.

**10. How can you achieve thread-safe singleton patterns in Java**
To achieve thread-safe singleton patterns in Java, you can use one of the following approaches:
1. Eager initialization with synchronized method:
```
public class Singleton {
    private static final Singleton instance = new Singleton();
    
    private Singleton() {
        // private constructor to prevent instantiation
    }
    
    public static synchronized Singleton getInstance() {
        return instance;
    }
}
```
In this approach, the instance is eagerly initialized when the class is loaded, ensuring thread safety through the use of a synchronized method. However, synchronization can impact performance, so this method is not recommended unless there is a specific requirement.
2. Double-checked locking:
```
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {
        // private constructor to prevent instantiation
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
The double-checked locking approach checks if the instance is null and, if so, enters a synchronized block to create a new instance. The volatile keyword ensures that multiple threads handle the instance variable correctly, and the double-checking inside the synchronized block improves performance by avoiding unnecessary synchronization once the instance is created.
3. Initialization-on-demand holder idiom (static inner class):
```
public class Singleton {
    private Singleton() {
        // private constructor to prevent instantiation
    }
    
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
```
In this approach, the singleton instance is created inside a static nested class. The instance is initialized only when getInstance() is called, and the static nested class guarantees thread safety during initialization. This method is efficient and thread-safe.
4. Enum singleton:
```
public enum Singleton {
    INSTANCE;
    
    // Singleton methods and properties
}
```
By using an enum, you automatically get thread safety and a guarantee of a single instance. Enum singletons are inherently thread-safe and handle serialization and reflection issues by default. You can access the singleton instance using Singleton.INSTANCE.

**11. What do you understand by the Open-Closed Principle (OCP)?**
The OCP states that software entities (classes, modules, functions, etc.) should be open for extension, meaning that you should be able to add new functionality or behavior to them without modifying their existing code. On the other hand, these entities should be closed for modification, implying that you should avoid making changes to their internal implementation once they are defined.

In practical terms, the OCP encourages developers to design their code in a way that allows for easy addition of new features or behaviors by leveraging mechanisms such as inheritance, interfaces, and abstractions. Instead of modifying existing code to accommodate new requirements, you should strive to extend the system by adding new classes, interfaces, or modules that build upon the existing ones.

By adhering to the OCP, you can achieve several benefits, including code that is easier to maintain, less prone to introducing bugs, and more resilient to changes. It promotes modular and loosely coupled designs, enabling developers to add new functionality without affecting the existing codebase, thus reducing the risk of unintended side effects.

Overall, the Open-Closed Principle encourages software developers to think about the future and design their systems in a way that allows for easy extensibility and minimizes the need for modifying existing code when requirements change.

**12. Liskov’s substitution principle**
The correct answer is 1. It means that if an object of type A can do something, an object of type B, which is a subtype of A, should also be able to perform the same action. In other words, objects of type B can be used as substitutes for objects of type A without affecting the correctness or behavior of the program. This principle ensures that subtypes are compatible with their supertypes and that the behavior specified in the supertype is preserved in its subtypes.



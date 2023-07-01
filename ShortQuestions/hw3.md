# 2. What is the checked exception and unchecked exception in Java, could you give one example?
**Checked exceptions** are exceptions that are checked at compile-time. This means that the Java compiler enforces the handling of these exceptions by either catching them or declaring them in the method signature using the "throws" keyword.

Example: IOException

**Unchecked exceptions**, also known as runtime exceptions, occur at runtime and are typically caused by programming errors or unexpected conditions. Unchecked exceptions are subclasses of RuntimeException or its subclasses. 

Example: NullPointerException

# 3. Can there be multiple finally blocks?
No, it can't. Only zero or one finally block is allowed.

# 4. When both catch and finally return values, what will be the final result ?
The return in the finally block

# 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception?
I believe the answer to Q2 already well illustrates the definition and difference.

# 6. What is the difference between throw and throws 
**throw**: The "throw" keyword is used to explicitly throw an exception within a method or block of code. When the "throw" statement is executed, it immediately transfers the control to the nearest enclosing "try-catch" block or to the caller of the method. It is used when you want to manually raise an exception to indicate an error or exceptional condition.

**throws**: The "throws" keyword is used in a method declaration to specify that the method may throw one or more types of exceptions. It is used to declare the exceptions that the method may throw to the caller.

# 7. Why do we put the Null/Runtime exception before Exception ?
Because the order to lay multiple 'catch exceptions' should be from narrow to broad. The NullPointerException and RuntimeException are both sub classes of Exception. Would cause confuse if Exception is ahead of these two, because only catch exception block would be executed then.

# 8. Why finally always be executed?
Because finally keyword is to ensure certain code block is always executed no matter whether an exception is thrown or not, so as to make sure that some memory or resource release step won't be skipped.

# 9. What are the types of design patterns in Java?
- Creational Patterns:
    * Singleton Pattern
    * Factory Method Pattern
    * Builder Pattern
- Structural Patterns:
    * Adapter Pattern
    * Decorator Pattern
    * Composite Pattern
    * Proxy Pattern
- Behavioral Patterns:
    * Observer Pattern
    * Command Pattern
    * Template Method Pattern

# 10. What are the SOLID Principles ?
- Single Responsibility Principle (SRP): A class should have only one reason to change, meaning it should have a single responsibility.

- Open-Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

- Liskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.

- Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. Split large interfaces into smaller and more specific ones.

- Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details, but details should depend on abstractions.

# 11. How can you achieve thread-safe singleton patterns in Java ?
### 1. Eager Initialization:
```
public class Singleton {
    private static final Singleton instance = new Singleton();
    
    private Singleton() {
        // Private constructor to prevent instantiation
    }
    
    public static Singleton getInstance() {
        return instance;
    }
}

```

### 2. Lazy Initialization:
```
public class Singleton {
    private Singleton() {
        // Private constructor to prevent instantiation
    }
    
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

### 3. Lazy Initialization with Double-Checked Locking
```
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {
        // Private constructor to prevent instantiation
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

# 12. What do you understand by the Open-Closed Principle (OCP) 
Software entities should be open for extension (new functionality) but closed for modification (existing code should not be changed). This promotes adaptability to change and reduces the risk of introducing bugs or unintended side effects.

# 13. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean?
3.  It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A
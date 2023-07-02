## 1. Practice collections
Done
## 2. What is the checked exception and unchecked exception in Java, could you give one example?
Checked exceptions are exceptions that must be declared in a method's signature or caught using a try-catch block. They are checked by the compiler at compile-time to ensure they are properly handled. Examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.

Unchecked exceptions, also known as runtime exceptions, do not need to be declared or caught explicitly. They occur during the execution of a program and are not checked by the compiler. Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, and IllegalArgumentException.

## 3. Can there be multiple finally blocks?
No, there can be only one finally block associated with a try-catch block. The finally block is used to ensure that certain code is executed regardless of whether an exception is thrown or not.

## 4. When both catch and finally return values, what will be the final result ?
The value returned will be from the finally block, as it executes last.

## 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
Runtime or unchecked exceptions are exceptions that occur during the execution of a program. They do not need to be declared or caught explicitly. These exceptions are typically caused by programming errors or exceptional conditions that cannot be reasonably recovered from. Examples include NullPointerException, ArrayIndexOutOfBoundsException, and IllegalArgumentException.

Compile or checked exceptions are exceptions that must be declared in a method's signature or caught using a try-catch block. They are checked by the compiler at compile-time to ensure they are properly handled. These exceptions are typically caused by external factors such as I/O errors or network issues. Examples include IOException, SQLException, and ClassNotFoundException.

## 6. What is the difference between throw and throws ?
"throw" is used to explicitly throw an exception within a method. It is followed by the exception instance or an expression that evaluates to an exception. It is used to indicate that an exceptional condition has occurred, and the control is transferred to the nearest catch block.

"throws" is used in a method declaration to indicate that the method may throw one or more checked exceptions. It specifies the exceptions that the method can throw, allowing the caller of the method to handle or propagate the exceptions. The caller is responsible for catching or declaring the checked exceptions specified in the throws clause.

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

Placing runtime exceptions before the general Exception class allows them to be caught or propagated separately from checked exceptions. It also provides a clear distinction between exceptions that are likely to occur due to programming errors and exceptions that are related to external factors or exceptional conditions.

## 7. Why finally always be executed ?

The finally block in Java is designed to always be executed, regardless of whether an exception is thrown or not. It ensures that certain code is executed, such as resource cleanup or final operations, regardless of the outcome of the try-catch block. The finally block is typically used to release resources, close connections, or perform other cleanup tasks that need to be done regardless of whether an exception occurs.

## 8. What are the types of design patterns in Java ?

There are several types of design patterns in Java, including:

- Creational Patterns: Singleton, Factory, Abstract Factory, Builder, Prototype.
- Structural Patterns: Adapter, Decorator, Proxy, Composite, Bridge, Facade, Flyweight.
- Behavioral Patterns: Observer, Strategy, Template Method, Command, Iterator, State, Visitor, Memento, Chain of Responsibility.
- Architectural Patterns: Model-View-Controller (MVC), Model-View-ViewModel (MVVM), Dependency Injection (DI), Repository, Service Locator.

## 9. What are the SOLID Principles ?
SOLID is an acronym for five design principles that help in designing maintainable and flexible software systems:

- Single Responsibility Principle (SRP): A class should have only one reason to change.
- Open-Closed Principle (OCP): Software entities should be open for extension but closed for modification.
- Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types.
- Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use.
- Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules; both should depend on abstractions.

## 10. How can you achieve thread-safe singleton patterns in Java ?

Thread-safe singleton patterns in Java can be achieved by using various techniques, such as:

- Eager Initialization: Creating the singleton instance when the class is loaded.
- Lazy Initialization: Creating the singleton instance on the first request.
- Double-Checked Locking: Using synchronized blocks to ensure thread safety.
- Enum Singleton: Implementing the singleton as an enum, which guarantees thread safety.

## 11. What do you understand by the Open-Closed Principle (OCP) ?

The Open-Closed Principle (OCP) states that software entities (classes, modules, functions) should be open for extension but closed for modification. This means that the behavior of a module can be extended without modifying its source code. It promotes the use of abstraction, inheritance, and polymorphism to achieve extensibility. By following the OCP, new features can be added by writing new code rather than modifying existing code, which helps in maintaining the stability and integrity of existing code.

## 12. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

choose 3.

## 13. Watch the design pattern video, and type the code, submit it to MavenProject folder

see files in MavenProject Directory











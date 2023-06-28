# Chuwa 0620 Assignment 3

### Zhizhou Xu

1. **Practice Collection**  
   Done.
2. **What is the checked exception and unchecked exception in Java, could you give one example?**

   - Runtime or unchecked exceptions are exceptions that do not require explicit handling or declaration by the programmer. They occur during the execution of a program due to logical errors or exceptional conditions. Examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`. The compiler does not enforce handling or declaration of these exceptions.

   - Compile or checked exceptions are exceptions that the compiler requires the programmer to handle or declare explicitly. They represent anticipated exceptional conditions, such as I/O errors or network errors. Examples include `IOException`, `FileNotFoundException`, and `SQLException`. The compiler enforces handling or declaration of checked exceptions using try-catch blocks or the "throws" keyword. This promotes robust code and ensures that potential exceptional situations are acknowledged and handled.

3. **Can there be multiple finally blocks?**  
   In Java, you can have multiple `finally` blocks associated with a single `try` block. The `finally` block is used to define a code section that will be executed regardless of whether an exception occurs or not. It is typically used to perform cleanup tasks, such as closing resources, releasing locks, or finalizing operations.

4. **When both catch and finally return values, what will be the final result?**  
   The final result will be the return value in finally block.

5. **What is Runtime/unchecked exception ? what is Compile/Checked Exception?**

   - Runtime or unchecked exceptions are exceptions that do not require explicit handling or declaration by the programmer. They occur during the execution of a program due to logical errors or exceptional conditions. Examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`. The compiler does not enforce handling or declaration of these exceptions.

   - Compile or checked exceptions are exceptions that the compiler requires the programmer to handle or declare explicitly. They represent anticipated exceptional conditions, such as I/O errors or network errors. Examples include `IOException`, `FileNotFoundException`, and `SQLException`. The compiler enforces handling or declaration of checked exceptions using try-catch blocks or the "throws" keyword. This promotes robust code and ensures that potential exceptional situations are acknowledged and handled.

6. **What is the difference between throw and throws?**  
   `throw` is used to explicitly throw an exception, while `throws` is used to declare that a method may throw certain exceptions, shifting the responsibility of handling or declaring those exceptions to the caller.

7. **Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?**  
   `NullPointerException` and other runtime exceptions are placed before `Exception` in the class hierarchy to differentiate them from checked exceptions. This ordering reflects the design and evolution of the Java language and exception handling mechanisms.

8. **Why finally always be executed?**  
   The `finally` block is always executed to ensure that certain code is executed regardless of whether an exception occurs or not. It provides a guarantee that cleanup or finalization tasks are performed, ensuring the desired behavior and consistency of the program.

9. **What are the types of design patterns in Java?**

   - Creational Patterns: Focus on object creation mechanisms, such as Singleton, Factory, and Builder patterns.

   - Structural Patterns: Deal with the composition of classes and objects, including Adapter, Decorator, and Composite patterns.

   - Behavioral Patterns: Address the interaction and communication between objects, like Observer, Strategy, and Command patterns.

10. **What are the SOLID Principles?**

    - Single Responsibility Principle (SRP): A class should have only one reason to change, focusing on a single responsibility.

    - Open/Closed Principle (OCP): Software entities should be open for extension but closed for modification, enabling easy extension without modifying existing code.

    - Liskov Substitution Principle (LSP): Subtypes should be substitutable for their base types, ensuring correct behavior when using derived classes.

    - Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use, promoting smaller, focused interfaces.

    - Dependency Inversion Principle (DIP): High-level modules should depend on abstractions, not on low-level modules, fostering loose coupling and flexibility.

11. **How can you achieve thread-safe singleton patterns in Java?**

    - Eager Initialization

    ```java
    public class Singleton {
        private static final Singleton instance = new Singleton();

        private Singleton() {
            // private constructor to prevent instantiation
        }

        public static Singleton getInstance() {
            return instance;
        }
    }
    ```

    - Lazy Initialization

    ```java
    public class Singleton {
        private static Singleton instance;

        private Singleton() {
            // private constructor to prevent instantiation
        }

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    ```

12. **What do you understand by the Open-Closed Principle (OCP)?**

    The Open-Closed Principle (OCP) states that software entities should be open for extension but closed for modification. This means that once a module or class is implemented and tested, it should not be modified directly. Instead, new functionality should be added through extension or subclassing, ensuring that existing code remains unchanged. The OCP promotes flexibility, maintainability, and scalability by allowing the system to evolve without disrupting its stability.

13. **(SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.**  
    It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.
14. **See details in /Maven Project/DesignPattern folder**

### HW3

1. What is the checked exception and unchecked exception in Java, could you give one example?

   - Checked Exceptions:
     Checked exceptions are exceptions that the Java compiler requires you to handle explicitly using a try-catch block or declare in the method signature using the throws keyword. This means that the programmer is aware of the possibility of an exception being thrown and must handle it appropriately. If a method throws a checked exception, the calling code must handle the exception or propagate it further.

   ```
   import java.io.BufferedReader;
   import java.io.FileReader;
   import java.io.IOException;

   public class FileExample {
       public static void main(String[] args) {
           BufferedReader reader = null;
           try {
               reader = new BufferedReader(new FileReader("example.txt"));
               String line = reader.readLine();
               // Process the line
           } catch (IOException e) {
               // Handle the exception
               e.printStackTrace();
           } finally {
               try {
                   if (reader != null)
                       reader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }
   ```

   - Unchecked Exceptions:\
     Unchecked exceptions, also known as runtime exceptions, do not need to be explicitly handled or declared. They occur due to programming errors, such as dividing by zero, accessing null references, or array index out of bounds. Unchecked exceptions are not checked by the compiler, and the programmer is not required to handle them.

   ```
    public class ArithmeticExample {
        public static void main(String[] args) {
            int dividend = 10;
            int divisor = 0;

            // The following line will throw an ArithmeticException
            int result = dividend / divisor;
        }
    }
   ```

2. Can there be multiple finally blocks?
   No, in Java, there can be only one finally block associated with a try-catch block. The finally block is used to specify a section of code that will always be executed, regardless of whether an exception is thrown or not.

3. When both catch and finally return values, what will be the final result ?
   When both the catch and finally blocks of a try-catch-finally structure contain return statements, the behavior depends on the situation.

   - If an exception is caught, the catch block will execute and return its specified value, while the finally block will still execute afterward.
   - If no exception occurs, the finally block's return statement will be the final result.
   - If an exception occurs but is not caught, the finally block will execute, but its return statement will be ignored as the exception propagates up the call stack.

4. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
   same as Q1

5. What is the difference between throw and throws ?
   The throw keyword is used to explicitly throw an exception within a method. The throws keyword is used in a method declaration to indicate that the method may throw one or more types of exceptions.

6. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
   exception before Exception ?
   In Java, NullPointerException and other runtime exceptions are considered to be special cases of exceptions that can occur at runtime due to programming errors or unexpected conditions. These runtime exceptions are subclasses of the RuntimeException class, which itself is a subclass of the Exception class.

7. Why finally always be executed ?
   It ensures that certain code is executed, such as closing resources or releasing locks, regardless of the outcome of the preceding try and catch blocks.

8. What are the types of design patterns in Java ?

   - Creational Patterns: These patterns focus on object creation mechanisms, providing flexibility and decoupling the object creation process from the client code. Examples include Singleton, Factory Method, Abstract Factory, Builder, and Prototype patterns.
   - Structural Patterns: These patterns deal with the composition of classes and objects to form larger structures while keeping them flexible and efficient. Examples include Adapter, Decorator, Composite, Facade, Bridge, and Proxy patterns.
   - Behavioral Patterns: These patterns are concerned with the interaction and communication between objects, defining common communication patterns between them. Examples include Observer, Strategy, Command, Iterator, Template Method, and Visitor patterns.

9. What are the SOLID Principles ?
   Single Responsibility Principle (SRP),Open/Closed Principle (OCP), Liskov Substitution Principle, Interface Segregation Principle, Dependency Inversion Principle

10. How can you achieve thread-safe singleton patterns in Java ?
    Double-Checked Locking (DCL)

11. What do you understand by the Open-Closed Principle (OCP) ?
    open to extension and closed for modification.

12. 1

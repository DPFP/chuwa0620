## 2. What is the checked exception and unchecked exception in Java, could you give one example?

Checked exceptions are exceptions that are checked at compile-time.

```java
public class ReadFileExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}
```

In the above example, the FileReader and BufferedReader classes can throw a checked exception IOException if there is an
error while reading the file.

Unchecked exceptions, also known as runtime exceptions, do not require explicit handling or declaration.

```java
public class DivisionExample {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 0;
        try {
            int quotient = dividend / divisor;
            System.out.println("Quotient: " + quotient);
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero!");
        }
    }
}
```

In the above example, if the divisor is set to zero, it will result in an ArithmeticException (unchecked exception) due
to division by zero.

## 3.Can there be multiple finally blocks?

No, in Java, there can be only one finally block associated with a try-catch block. The finally block is used to specify
a code section that will be executed regardless of whether an exception occurs or not.

## 4. When both catch and finally return values, what will be the final result ?

It's important to note that executing a return statement in either the catch or finally block will cause the method to
terminate and return the specified value. If there are no exceptions or if the try block completes successfully without
any exceptions, the finally block will still execute, but the value returned from the finally block will not impact the
final result of the method.

## 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?

* Runtime exceptions, also known as unchecked exceptions, are exceptions that do not need to be declared or handled
  explicitly by the programmer. They extend the RuntimeException class or its subclasses.
* Checked exceptions are exceptions that need to be declared using the throws keyword or handled using try-catch blocks.
  They are checked by the compiler at compile-time to ensure that they are either caught and handled or declared to be
  thrown.

## 6. What is the difference between throw and throws ?

* throw is a keyword used to explicitly throw an exception in Java. It is used within a method to manually throw an
  exception when a specific condition or error occurs. The throw statement is followed by an instance of an exception
  class or one of its subclasses.
* throws is used in a method signature to declare that the method may throw one or more types of checked exceptions. It
  specifies the exceptions that can be thrown by the method but does not actually throw the exceptions.

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

By placing null/runtime exceptions before checked exceptions, the code becomes more readable and follows a logical flow.
It emphasizes the need to address and fix programming errors first, and then handle exceptions that are beyond the
control of the program.

* if b / a when a == 0, ArithmeticException comes first.
* null/runtime exception occurs when execute 'eqaul'(null, 'aa').

## 8. Why finally always be executed ?

the purpose of the finally block is to provide a reliable mechanism for executing cleanup code, releasing resources, and
ensuring the expected behavior of the program, regardless of exceptional conditions or control flow changes. It helps
maintain the stability, correctness, and integrity of the code by enforcing the execution of critical cleanup tasks.

## 9. What are the types of design patterns in Java ?

> Creational Design Pattern

* Factory Pattern
* Abstract Factory Pattern
* Singleton Pattern
* Prototype Pattern
* Builder Pattern.

> Structural Design Pattern

* Adapter Pattern
* Bridge Pattern
* Composite Pattern
* Decorator Pattern
* Facade Pattern
* Flyweight Pattern
* Proxy Pattern

> Behavioral Design Pattern

* Chain Of Responsibility Pattern
* Command Pattern
* Interpreter Pattern
* Iterator Pattern
* Mediator Pattern
* Memento Pattern
* Observer Pattern
* State Pattern
* Strategy Pattern
* Template Pattern
* Visitor Pattern

## 10. What are the SOLID Principles ?

* S - Single-responsiblity Principle: A class should have one and only one reason to change, meaning that a class should
  have only one job.
* O - Open-closed Principle: Objects or entities should be open for extension but closed for modification.
* L - Liskov Substitution Principle: Let q(x) be a property provable about objects of x of type T. Then q(y) should be
  provable for objects y of type S where S is a subtype of T.
* I - Interface Segregation Principle: A client should never be forced to implement an interface that it doesn’t use, or
  clients shouldn’t be forced to depend on methods they do not use.
* D - Dependency Inversion Principle: Entities must depend on abstractions, not on concretions. It states that the
  high-level module must not depend on the low-level module, but they should depend on abstractions.

## 11. How can you achieve thread-safe singleton patterns in Java ?

* Eager Initialization

```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        // Private constructor to prevent external instantiation
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

* Lazy Initialization with Double-Checked Locking (DCL)

```java
public class Singleton {
    private static volatile Singleton INSTANCE;

    private Singleton() {
        // Private constructor to prevent external instantiation
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
```

* Initialization-on-Demand Holder (IoDH) idiom

```java
public class Singleton {
    private Singleton() {
        // Private constructor to prevent external instantiation
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

## 12. What do you understand by the Open-Closed Principle (OCP) ?

In simpler terms, the OCP advocates that the behavior of a class or module should be easily extendable without modifying
its source code. It promotes the idea that the existing code should be closed for modification, ensuring that any
changes or enhancements can be made through extension or addition of new code, rather than modifying the existing
codebase.

## 13. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

1. It mean that if the object of type A can do something, the object of type B could also be able tp perform the same
   thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could
   substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

Choose 1.It mean that if the object of type A can do something, the object of type B could also be able tp perform the
same thing

## 14. 
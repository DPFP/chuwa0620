## 1
Done

## 2
Checked exceptions are exceptions that are checked at compile-time. For example: IOException.

Unchecked exceptions, also known as runtime exceptions, do not need to be declared explicitly in a method's signature or caught using a try-catch block. These exceptions occur at runtime and are usually caused by programming errors or unexpected conditions. For example: NullPointerException.

## 3
No, in Java, there can be only one finally block associated with a try-catch block. The finally block is used to define a section of code that will be executed regardless of whether an exception is thrown or not.

## 4
It will only return the value in the finally block.

## 5
Checked Exceptions:

Checked exceptions are exceptions that are checked at compile-time.
The compiler enforces that these exceptions are either caught using a try-catch block or declared to be thrown by the method using the throws keyword.


Unchecked Exceptions:

Unchecked exceptions, also known as runtime exceptions, do not need to be declared explicitly in a method's signature or caught using a try-catch block.
These exceptions occur at runtime and are usually caused by programming errors or unexpected conditions.

## 6
throw:

The throw keyword is used to explicitly throw an exception in Java.
It is used within a method to indicate that an exceptional condition has occurred and the method wants to propagate that exception to its caller.

throws:

The throws keyword is used in a method declaration to specify that the method may throw one or more types of exceptions.
It is used to delegate the responsibility of handling exceptions to the caller of the method.

## 7
Because runtime exceptions are child classes of exceptions. If we put exception first, it will catch all possible exception in that block and we lose accuracy information about each exception.

## 7
The finally block in Java is designed to ensure that a section of code is always executed, regardless of whether an exception is thrown or caught.

## 8
Creational, Structural, and Behavioral.

## 9
Single Responsibility Principle, Open/Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, Dependency Inversion Principle.

## 10
Use Eager Initialization.

## 11
It states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. The principle emphasizes that existing code should be closed for modifications, preventing changes that could introduce bugs or destabilize the system, while still allowing for the extension of functionality through the addition of new code.

## 12
1

## 13
See maven folder
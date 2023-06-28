# HW3

1. What is the **checked exception** and **unchecked exception** in Java, could you give one example?

   	- These are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword.
   	- These are the exceptions that are not checked at compile time. In C++, all exceptions are unchecked, so it is not forced by the compiler to either handle or specify the exception. It is up to the programmers to be civilized, and specify or catch the exceptions. In Java, exceptions under *Error* and *RuntimeException* classes are unchecked exceptions, everything else under throwable is checked. 
    - Examples
        - Checked exceptions : IOException, InterruptedException.
        - Unchecked exception : Null Pointer Exception, IndexOutOfBound Exception, Numberformat Exception.

2. Can there be multiple finally blocks? 

   	- Per try/catch/finally statement only can have one finally clause. But there can be multiple such statements.

3. When both catch and finally return values, what will be the final result?

   	- The finally block will still execute, even if the catch block has a return statement. If both catch and finally return, the receiving method will get the returned value from the finally block.

4. What is **Runtime/unchecked exception**? what is Compile/Checked Exception?
    - An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation. 
 		-  For example, if you have declared an array of size 5 in your program, and trying to call the 6th element of the array then an *ArrayIndexOutOfBoundsExceptionexception* occurs.
    - A checked exception is an exception that occurs at the compile time, these are also called as compile time exceptions. These exceptions cannot simply be ignored at the time of compilation, the programmer should take care of (handle) these exceptions.

5. what is the difference between throw and throws?
    - Both throw and throws are concepts of exception handling in Java. 
    - The throws keyword is used to declare which exceptions can be thrown from a method.
    - While the throw keyword is used to explicitly throw an exception within a method or block of code.


6. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

    - Exception is the parent class of null/runtime exceptions.
    - If we put exception before null / runtime exception. All excepetions will be exception catch. Then those exceptions will not get specfic deal with.

7.  Why **finally** always be executed ?
   	- This is useful **if you need to run cleanup code regardless of what happens**. For example, as a cleanup, you should always close a file no matter what.

8. What are the types of design patterns in Java ?

    - Design patterns can be classified in three categories: Creational, Structural and Behavioral patterns.
    - **Creational Patterns** - These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new opreator. This gives program more flexibility in deciding which objects need to be created for a given use case.
    - **Structural Patterns** - These design patterns concern class and object composition. Concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionalities.
    - **Behavioral Patterns** - These design patterns are specifically concerned with communication between objects.

9. What are the **SOLID** Principles ?

   	- SOLID refers to five design principles in object-oriented programming, designed to reduce code rot and improve the value, function, and maintainability of software. The SOLID principles help the user develop less coupled code. If code is tightly coupled, a group of classes are dependent on one another. This should be avoided for better maintainability and readability.
    - SOLID design is an acronym for the following five principles:
    - [Single Responsibility Principle](https://www.jrebel.com/blog/solid-principles-in-java#srp)
    - [Open-Closed Principle](https://www.jrebel.com/blog/solid-principles-in-java#ocp)
    - [Liskov Substitution Principle](https://www.jrebel.com/blog/solid-principles-in-java#lsp)
    - [Interface Segregation Principle](https://www.jrebel.com/blog/solid-principles-in-java#isp)
    - [Dependency Inversion Principle](https://www.jrebel.com/blog/solid-principles-in-java#dip)

10. How can you achieve **thread-safe singleton** patterns in Java ?

    - Create the private constructor to avoid any new object creation with new operator. 
    - Declare a private static instance of the same class. 
    - Provide a public static method that will return the singleton class instance variable.

11. What do you understand by the **Open-Closed Principle (OCP)** ?

    - The Open-Closed Principle (OCP) states that software entities (classes, modules, methods, etc.) should be open for extension, but closed for modification. 
    - In practice, this means creating software entities whose behavior can be changed without the need to edit and recompile the code itself.

12. **Liskov’s substitution principle states** that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

    1. It mean that if the object of type A can do something, the object of type B could also be able tp 
       perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of 
       type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
    
    - **Answer is 1**

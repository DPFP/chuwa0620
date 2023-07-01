# HW 3
## Q2.  What is the checked exception and unchecked exception in Java, could you give one example?
```
A checked exception in Java represents a predictable, erroneous situation that can occur even if a software library 
is used as intended.
"FileNotFoundException"
An unchecked exception represents an error in programming logic, not an erroneous situation that might reasonably occur 
during the proper use of an API.
"NullPointerException"
```

## Q3.  Can there be multiple finally blocks?
```
There can only be one finally block
```

## Q4.  When both catch and finally return values, what will be the final result ?
```
finally
```

## Q5.  What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
```
A checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime.
```

## Q6.  What is the difference between throw and throws ?
```
We use the throws keyword to declare what exceptions we can throw from a method. The throw keyword, on the other hand,
 is mainly used to throw an exception explicitly within a block of code or a method.
```

## Q7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
```
Null/Runtime exception are subclass of exception, we want to catch it first.
```

## Q7.  Why finally always be executed ?
```
Java is made this way.
```

## Q8.  What are the types of design patterns in Java ?
```
Java design patterns are divided into three categories - creational, structural, and behavioral design patterns
```

## Q9.  What are the SOLID Principles ?
```
S - Single-responsiblity Principle
O - Open-closed Principle
L - Liskov Substitution Principle
I - Interface Segregation Principle
D - Dependency Inversion Principle
```

## Q10.  How can you achieve thread-safe singleton patterns in Java ?
```
Create the instance variable at the time of class loading
```

## Q11.  What do you understand by the Open-Closed Principle (OCP) ?
```
We want to design our code so that to add new featrue we do not need to modify original file.Such as a class should 
be extendable without modifying the class itself.
```

## Q12
(SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type
A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your
answer.
1.  It mean that if the object of type A can do something, the object of type B could also be able tp
    perform the same thing
2.  It means that all the objects of type A could execute all the methods present in its subtype B
3.  It means if a method is present in class A, it should also be present in class B so that the object of
    type B could substitute object of type A.
4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
```
I would chose A.
```

## Q13.  Watch the design pattern video, and type the code, submit it to MavenProject folder
```
See MavenProject folder
```
#### 1. Practice collection

Done

#### 2. What is the checked exception and unchecked exception in Java, could you give one example?

checked exceptions：

These are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword. 

**Example:**

```java

// Java Program to Illustrate Checked Exceptions
// Where FileNotFoundException does not occur
 
// Importing I/O classes
import java.io.*;
 
// Main class
class GFG {
 
    // Main driver method
    public static void main(String[] args)
        throws IOException
    {
 
        // Creating a file and reading from local repository
        FileReader file = new FileReader("C:\\test\\a.txt");
 
        // Reading content inside a file
        BufferedReader fileInput = new BufferedReader(file);
 
        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());
 
        // Closing all file connections
        // using close() method
        // Good practice to avoid any memory leakage
        fileInput.close();
    }
}
```

**Output:** 

```java
First three lines of file "C:\test\a.txt"
```

Unchecked Exceptions:

These are the exceptions that are not checked at compile time. In Java, exceptions under *Error* and *RuntimeException* classes are unchecked exceptions, everything else under throwable is checked. 

**Example:**

```java
// Java Program to Illustrate Un-checked Exceptions

// Main class
class GFG {

	// Main driver method
	public static void main(String args[])
	{
		// Here we are dividing by 0
		// which will not be caught at compile time
		// as there is no mistake but caught at runtime
		// because it is mathematically incorrect
		int x = 0;
		int y = 10;
		int z = y / x;
	}
}

```

**Output**

```java
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Main.main(Main.java:5)
Java Result: 1
```

#### 3. Can there be multiple finally blocks?

No



#### 4. When both catch and finally return values, what will be the final result ?

If both catch and finally return, the receiving method will get the returned value from the finally block.



#### 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?

Same with answer in Q2.



#### 6. What is the difference between throw and throws ?



#### 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime



#### 8. Why finally always be executed ?

In Java, the `finally` block is always executed after a `try` or `catch` block, regardless of whether an exception is thrown or not. This ensures **cleanup** or necessary final steps are completed, like closing files or releasing system resources. It enhances the robustness and security of the code.



#### 9. What are the types of design patterns in Java ?

Creational Patterns
Abstract Factory
Builder
Factory Method
Prototype
Singleton
Structural Patterns
Adapter

#### 10. What are the SOLID Principles ?

- single responsibility principle, 
- open-closed principle, 
- Liskov substitution principle, 
- interface segregation principle
- dependency inversion principle.



#### 11. How can you achieve thread-safe singleton patterns in Java ?

- Create the private constructor to avoid any new object creation with new operator.
- Declare a private static instance of the same class.
- Provide a public static method that will return the singleton class instance variable.

#### 12. What do you understand by the Open-Closed Principle (OCP) ?

In object-oriented programming, the open–closed principle (OCP) states "software entities (classes, modules, functions, etc.) **should be open for extension, but closed for modification"**; that is, such an entity can allow its behaviour to be extended without modifying its source code.

#### 13. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your
answer.

1. It mean that if the object of type A can do something, the object of type B could also be able tp
  perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
  type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

The correct answer is:

It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

#### 6. Watch the design pattern video, and type the code, submit it to MavenProject folder

singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9

Done
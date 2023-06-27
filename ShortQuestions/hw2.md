1.
Write up Example code to demonstrate the three foundmental concepts of OOP. (reference
Code Demo


1.
Encapsulation;
The example codes below can both demonstrate Encapsulation, hide all the field, inner classes and methods within a class.
2.
Polymorphism;
public class PolyTest {




public static class House {


       public House() {
           win();
       }


       public void roof() {
           System.out.println("Par roof");
       }


       private void win() {
           System.out.println("Par win");
       }


       public void door() {
           System.out.println("Par door");
       }
}


public static class MyHouse extends House {


       public MyHouse() {
//            super();
win();
}


//        @Override
public void win() {
System.out.println("Sub win");
}


       public void tree() {
           System.out.println("Sub tree");
       }


       public int tree(int x) {
           return 1;
       }
}


public static void main(String[] args) {
MyHouse mh = new MyHouse();
//        mh.roof();
//        mh.win();
//        mh.tree();
//        System.out.println("-----------------");
//
//        House h = new MyHouse();
//        h.roof();
//        // calling the sub win()
//        // cause it's object level function, coming from the object
//        h.win();
////        h.tree();
//        System.out.println("------------------");
//
//        // downcasting, need to make sure:
//        // 1. object need to be available for that type
//        // 2. need to mention the type
//        MyHouse mh2 = (MyHouse) h;
//        mh2.roof();
//        mh2.win();
//        mh2.tree();
//
//        A a = new A();
//        B b = (B)a;
//
//        System.out.println(123);
//        System.out.println("abc");




}


public static class A{


}


public static class B extends A{


}
}

3.
Inheritance;
public class InheritanceTest {


// 1 java class can extends from at most 1 class, but able to implements multi interfaces
// interface can extends from other interfaces, but cannot implement any
public static class InheritancePar {
public static void foo() {
System.out.println("Par foo...");
}


       public void bar() {
           System.out.println("Par bar...");
       }
}




public static class InheritanceSub extends InheritancePar {
// static function cannot be extended, nor overridden


       public static void foo() {
           System.out.println("Sub foo...");
       }


       @Override
       public void bar() {
           System.out.println("Sub bar...");
       }
}


public static void main(String[] args) {
// if a function cannot be found from an object
// then search from it's reference class
// if still not found, keep searching from its parent class
InheritancePar par = new InheritancePar();
//        par.foo();


       InheritanceSub sub = new InheritanceSub();
       sub.foo();  // static func not accessed by a static way


       sub.bar();


       Object o;


       AccessPar ap = new AccessSub1();
       ap.f6();
}
}


2.
What is wrapper class in Java and Why we need wrapper class?
Wrapper classes in Java are classes that encapsulate primitive data types and provide additional methods and functionality. They are used for conversion, object-oriented operations, handling null values, working with generic types, and providing standardized interfaces.

3.
What is the difference between HashMap and HashTable?
HashTable : thread safe, lock the whole obj
HashMap: allows null key and value, not thread safe
ConcurrentHashmap: allows null key and value thread safe, lock the bucket

4.
What is String pool in Java and why we need String pool?
The String pool in Java is a special area in the JVM that stores String objects. It allows for memory efficiency, optimized string comparisons, string interning, and storage of string constants. It helps reduce memory usage and improve performance when working with strings.
5.
What is Java garbage collection?

Java garbage collection is an automatic memory management system provided by the JVM. It frees up memory by automatically reclaiming objects that are no longer needed. It simplifies memory management, prevents memory leaks, and improves developer productivity.

6.
What are access modifiers and their scopes in Java?
public : anywhere
protected : same package and subclass
default : same package
private : same class

7.
What is final key word? (Filed, Method, Class)
final is a keyword in java that can be added in front of a class/method/variable,
final variable cannot be changed once instantiate
final class cannot be extended
final method cannot be overridden

8.
What is static keyword? (Filed, Method, Class). When do we usually use it?

Static Field : means that the field belongs to the class itself, rather than object, it will be loaded and initilized 
                when the class is first loaded before any instances are created.
Static Method: same as static field, belong to the class rather than instance. static method can be invoked without 
                creating an object
Static Nested Class: Defined within another class. Can be accessed using the enclosing class name;

9.
What is the differences between overriding and overloading?
they both poly concepts
overriding : allows child classes to have different behaviors than their parent by allowing them to override the functions from their parent
overloading : allow a class to have the same functions with different parameters.


10.
What is the differences between super and this?
this refers to the object itself,
super refers to the superclass of the object

11.
What is the Java load sequence ?
Loading, Verification, Preparation, Resolution,Initialization

12.
What is Polymorphism? And how Java implements it ?
Polymorphism is a fundamental concept in object-oriented programming that allows objects of different classes to be 
treated as objects of a common superclass or interface. It enables code to be written in a generic and flexible way, 
promoting code re-usability and extensibility.
13.
What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is a principle of object-oriented programming that combines data and methods into a single unit called a class, and restricts direct access to the internal state of an object. It provides a way to hide the internal implementation details of an object and only expose a controlled interface for interacting with it. In essence, encapsulation bundles data and methods together, and protects the data from external interference.

Java implements encapsulation through the use of access modifiers: public, protected, private, and default (no modifier). These modifiers control the visibility and accessibility of class members (fields, methods, and nested classes) to other classes and code outside the class.

Public: Public members are accessible to all classes and code.

Protected: Protected members are accessible within the same package and in subclasses (even if they are in a different package).

Private: Private members are only accessible within the same class. They cannot be accessed or modified directly by code outside the class.

Default: Default (no modifier) members are accessible within the same package but not outside of it. If no access modifier is specified, it defaults to the package-private level.
14.
What is Interface and what is abstract class? What are the differences between them?
Interfaces:

Contains only method signatures and constants.
Cannot be instantiated directly.
Supports multiple inheritance through implementation.
Methods are implicitly public and abstract (prior to Java 8) or can have default and static implementations.
Used for achieving abstraction and defining contracts.
Abstract Classes:

Can contain both method declarations and concrete methods.
Cannot be instantiated directly.
Supports single inheritance through extension.
Abstract methods are declared with the abstract keyword and must be implemented by subclasses.
Used for providing a base class with common behavior and allowing subclasses to provide specific implementations.
In summary, interfaces are purely abstract and define contracts, while abstract classes can contain both abstract and concrete methods, providing partial implementation for subclasses.
15.
(OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )
If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)

16.
What are Queue interface implementations and what are the differences and when to use what?
In Java, the Queue interface represents a collection that orders elements in a specific manner for processing. There are several implementations of the Queue interface available in the Java Collections Framework, each with its own characteristics and best use cases. Here are some commonly used implementations:

LinkedList:

Implements both the Queue and Deque interfaces.
Provides efficient insertion and removal operations at both ends of the queue.
Suitable for scenarios that require frequent addition or removal of elements at both ends.
ArrayDeque:

Implements both the Queue and Deque interfaces.
Uses a resizable array to store elements.
Offers better performance than LinkedList in most scenarios.
Suitable for most queue operations and provides a good all-around implementation.
PriorityQueue:

Implements the Queue interface.
Orders elements based on their natural order or a custom comparator.
Provides efficient retrieval of the highest-priority element.
Suitable for scenarios where elements need to be processed based on their priority.
When to use which implementation:

Use LinkedList when you need a general-purpose implementation that supports efficient insertion and removal at both ends of the queue. It is useful when you have requirements for a double-ended queue (Deque) in addition to the Queue operations.

Use ArrayDeque when you want a high-performance implementation that supports both Queue and Deque operations. It is typically the preferred choice for most queue scenarios.

Use PriorityQueue when you need to prioritize elements based on a specific ordering criterion. It is suitable for scenarios where elements need to be processed in a particular order of priority.
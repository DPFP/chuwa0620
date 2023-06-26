## HW2
### Name: Yuanzhen Lin

### 1. Write up Example code to demonstrate the three fundamental concepts of OOP.(referenceCodeDemo repo as example)
1. Encapsulation\
In java file: EncapsulationDemo.java
2. Polymorphism\
In java file: Polymorphism.java
3. Inheritance\
In java file: Inheritance.java


### 2. What is wrapper class in Java and Why we need wrapper class
A wrapper class in Java is a class whose object wraps or contains primitive data types. In Java, everything is an object, which means we can generally manipulate data by methods, but the primitive data types like int, char, float, boolean, byte, short, long, double are not objects. Therefore, to make them fit into the object-oriented world of Java, we need wrapper classes.


### 3. What is the difference between HashMap and HashTable
1. Thread-Safety and Synchronization:
   Hashtable is thread-safe and synchronized, which means only one thread can modify the table at a given moment. This makes Hashtable suitable for multithreaded environments where you need to ensure data consistency across threads.
   On the other hand, HashMap is not synchronized, meaning it's not thread-safe. If you use it in a multithreaded environment, multiple threads can modify the map concurrently, leading to data inconsistency. 
2. Null keys and null values:
   HashMap allows one null key and multiple null values. This means you can insert a key-value pair like hashMap.put(null, "value") or hashMap.put("key", null).
   Hashtable, however, does not allow any null key or null value. Trying to insert a null key or value will throw a NullPointerException
3. Performance:
   Due to its unsynchronized nature, HashMap is generally faster than Hashtable. It doesn't need to deal with the overhead of synchronization.
4. Iterating the values:
   HashMap provides an iterator, which is fail-fast. It means if one thread is iterating over the map and another thread tries to modify the map concurrently (except through the iterator's own remove method), it will throw a ConcurrentModificationException.
   Hashtable provides an enumerator and an iterator, but the enumerator is not fail-fast.
5. Legacy Class:
   Hashtable is considered as a legacy class in Java. It was part of the original JDK, but HashMap was introduced later as part of the Java 2 Platform (also known as Java 1.2) in the Collections Framework.
   Despite these differences, it's important to choose the appropriate class based on the specific needs of your program, such as whether you need thread safety, if null values or keys are necessary, and the performance characteristics you require.


### 4. What is String pool in Java and why we need String pool?
The String Pool in Java is a pool of strings stored in the Java Heap Memory. We require String Pool for memory optimization.
By reusing existing objects for string literals, Java saves a significant amount of memory, especially for programs that use many strings. This is very efficient in terms of memory utilization.
Searching in the pool for an existing string is faster than creating a new string object, which can benefit performance.

### 5. What is Java garbage collection?
Java Garbage Collection (GC) is a part of Java's memory management system that automatically reclaims the runtime unused memory. It's a form of automatic memory management that frees up memory that is no longer needed by objects, arrays, etc.


### 6. What are access modifiers and their scopes in Java?
Access modifiers in Java are keywords that set the accessibility (visibility) of classes, interfaces, variables, methods, constructors, etc. They are used to restrict the scope of a class, constructor, variable, method, or data member.
There are four types of access modifiers in Java:
Default, Private, Public, Protected.

Their scope are:

Default - declarations are visible only within the package (package private)

Private - declarations are visible within the class only

Protected - declarations are visible within the package or all subclasses

Public - declarations are visible everywhere

### 7. What is final keyword? (Filed,Method,Class)
The final keyword in Java is used to restrict the user. It can be applied to variables, methods, and classes.

Final Variables: When the final keyword is used with variables, the value of the variable cannot be changed once it's initialized.

Final Methods: When a method is declared as final, it cannot be overridden by subclasses.

Final Classes: When a class is declared as final, it cannot be subclassed. 

### 8. What is static keyword? (Filed,Method,Class). When do we usually use it?

Static keyword in Java indicates that a particular member is not an instance, but rather part of a type. The static member will be shared among all instances of the class, so we will only create one instance of it.

Static Variables: When a variable is declared as static, it gets created in the memory as soon as the class is loaded, and there is only one copy of that variable that is shared with all instances of that class.

Static Methods: When a method is declared as static, it is a static method. It belongs to the class and not to the object. A static method can access only static data. It cannot access non-static data (instance variables) or call non-static methods directly.

Static Blocks: These are used for initializing the static variables. The static block is executed only once: the first time the class is loaded into memory.

Static Classes: In Java, we can have static inner classes. The static inner class is nested static class which is a static member of outer class. It can be accessed without instantiating the outer class, using other static members.

When to use:

When we want to have a variable that is common to all objects of a class, such as a counter that keeps track of the number of objects of a class.\
When we need to define a method that doesn't use instance variables.\
When we are writing utility classes, which are classes that group related methods together, and do not require instantiation. For instance, Java's Math class is final and has static methods.\
When we want to create a nested static class for packaging convenience.

### 9. What is the differences between overriding and overloading?
#### Overloading:
Overloading happens at compile time.\
Better performance because the binding is being done at compile time.\
Private and final methods can be overloaded.\
Return type of method does not matter in case of method overloading.\
Arguments must be different in the case of overloading.\
It is being done in the same class.\
Mostly used to increase the readability of the code.

#### Overriding:
Overriding happens at runtime.\
Gives less performance because the binding is being done at run time.\
Private and final methods can NOT be overridden.\
Return type of method must be the same in the case of overriding.\
Arguments must be the same in the case of overriding.\
Base and derived(child) classes are required here.\
Mostly used to provide the implementation of the method that is already provided by its base class.


### 10. What is the differences between super and this?
#### super Keyword: 
The super keyword in Java is a reference variable which is used to refer to the immediate parent class object.
#### this Keyword:
this keyword is a reference to the current object — the object whose method or constructor is being called. You can use this to access members (methods or variables) of the current object.

### 11. What is the Java load sequence?
1. Loading: This is the first phase in which the class loader reads the .class file, generates a corresponding binary data, and saves it in the method area.
2. Linking: This phase verifies the binary data and makes sure the .class file follows the Java Language Specification (JVM specification). It also performs allocation for the class variables and initializing them to default values.
3. Initialization: This phase invokes Java code that initializes class variables to their proper starting values. This is done via a call to the class's static initialization code, which is automatically included in any class that has one or more static variables.

### 12. What is Polymorphism ? And how Java implements it ?
Polymorphism in Java allows objects to be treated as instances of their supertypes, whether the supertype is a class or an interface. This leads to a very powerful type system that promotes extensibility and code reuse.

Java supports polymorphism in two ways:
1. Compile-Time Polymorphism (or Static Polymorphism):\
   This form of polymorphism is achieved through method overloading. 
2. Run-Time Polymorphism (or Dynamic Polymorphism):\
   This form of polymorphism is achieved through method overriding. In method overriding, a subclass provides a different implementation of a method that is already present in its parent class. The decision about which version of the overridden method to run is made at runtime based on the actual type of the object, not the type of the reference.

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).\
In Java, encapsulation is implemented using a combination of classes, interfaces, and access modifiers (private, public, protected, and package-private).\
Encapsulation has several benefits:
1. Control of data: By encapsulating the variables of the class, you have control over what can and cannot be set to those variables.
2. Increased security: Data members can be hidden from outside access, making the object more secure.
3. Flexibility and maintainability: The user does not need to know the internal implementation of the class, and the internal implementation can be changed without affecting users of the class.

### 14. What is Interface and what is abstract class? What are the differences between them?
#### Interface
An interface in Java is a blueprint of a class. It has static constants and abstract methods. The interface in Java is a mechanism to achieve abstraction and multiple inheritance.

#### Abstract
An abstract class in Java is a class that can't be instantiated, meaning you cannot create an object of an abstract class. It is used to declare common characteristics of subclasses. An abstract class can have abstract methods as well as concrete methods.

#### Difference
Instantiation: An abstract class can have a constructor and it can be called during the creation of an instance of a subclass. In contrast, an interface can't be instantiated at all.

Implementation: All methods of an interface are implicitly abstract and public. An abstract class, on the other hand, can have both abstract and non-abstract methods.

Default methods: From Java 8 onwards, interfaces can have default and static methods, which can have an implementation.

Fields: Interfaces can only have static and final fields (constants), while abstract classes can have both static and non-static fields.

Inheritance: A class can implement multiple interfaces, but it can only extend one abstract class.

Access Modifiers: Interface methods are implicitly public, and cannot be private or protected. Abstract class methods can have any access modifier.


### 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )
1. If you have no ability to design it,please find the solution in internet,then understand it,and re-type it.(Do NOT just copy and paste)

### 16. What are Queue interface implementations and what are the differences and when to use what?
In Java, the Queue interface is provided in the java.util package and it extends the Collection interface.\
The Queue interface supports all basic methods available in the Collection interface in addition to several methods that are specific to a queue data structure, like offer(), poll(), peek() etc.\
The Queue interface has several implementations including:
1. LinkedList:\
LinkedList class is a doubly-linked list implementation of the List and Deque interfaces. It can also be used as a Queue. It allows null elements and provides methods for maintaining the list in both directions.
2. PriorityQueue: \
PriorityQueue class is a priority-queue based on the heap data structure. It does not allow null values. The elements in the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used.
3. ArrayDeque: \
ArrayDeque class is a resizable-array implementation of the Deque interface. It also can be used as a Queue. It does not support concurrent access by multiple threads and does not allow null elements. It's typically faster than LinkedList for adding and removing at both ends.
4. ConcurrentLinkedQueue:\
ConcurrentLinkedQueue class is an unbounded thread-safe queue based on linked nodes. It's appropriate to use when many threads will share access to a common collection and you don't need to block when adding to the queue.
5. LinkedBlockingQueue:\
LinkedBlockingQueue is an optionally-bounded blocking queue based on linked nodes. It's useful when you need to control the number of elements in your queue and you need to wait to add elements if the queue is full.
6. PriorityBlockingQueue:\ 
PriorityBlockingQueue is an unbounded blocking queue that uses the same ordering rules as PriorityQueue and supplies blocking retrieval operations.

The choice of which one to use depends on your specific needs:
1. Use LinkedList or ArrayDeque if you need a general-purpose Queue and don't have specific additional needs.

2. Use PriorityQueue if you need to process elements in order based on their priority.

3. Use ConcurrentLinkedQueue if you need a non-blocking queue that will be used by multiple threads.

4. Use LinkedBlockingQueue if you need a blocking queue of bounded size.

5. Use PriorityBlockingQueue if you need a queue that blocks when retrieving elements but orders them based on priority.












# Homework2
#Chingpo Lin

-----

## Q2: What is wrapper class in Java and Why we need wrapper class?

wrapper class is to encapsulate a primitive data type and provide methods to manipulate data as an object. 

By wrapped into wrapper class, we could have following main benefits:  
1. allow null value
2. stored into collections like arraylist
3. have more utility methods
4. have object-oriented operations

---

## Q3: What is the difference between HashMap and HashTable?

- HashTable is thread-safe which achieved by synchronization while HashMap is not
- HashTable do not allow null key or value
- HashMap have better performance since do not need synchronized by default

---

## Q4: What is String pool in Java and why we need String pool?

String pool is an area of memory which stores string. It is a part of Java heap memory and improve performance when working with strings.

When we use String a = "sth", we first find it in string pool and return the reference if exists.

---

## Q5: What is Java garbage collection?

Java garbage collection is a mechanism to manage memory in JVM. It collects memory which is no longer needed by the program automatically.


---

## Q6: What are access modifiers and their scopes in Java?

- public: allows unrestricted access to the class, method variable or constructor from any other class.
- protected: allows access to the class, method variable or constructor within the same package or subclasses from different packages.
- default: allows access to the class, method variable or constructor only within the same package
- private: allows access to the class, method variable or constructor only within the same class

---

## Q7: What is final key word? (Filed, Method, Class)

- final variables: cannot change and must initialized at declaration or constructor.
- final method: cannot be overridden by subclass
- final class: cannot have subclasses

final key word can help in secure and thread-safe code.

---

## Q8: What is static keyword? (Filed, Method, Class). When do we usually use it?

static keyword is used to declare entities that belong to class itself instead of the instance of class

- static variable (class variable): shared to all instance of class and initialized only once at the start of program when the class is first loaded. we used when we have a variable need to access in the class and initialized only once for memory efficiency.
- static method: can be called directly on class without creating an object, and it can only access to static variable (since non-static variable is not loaded at this time). They are often used for utility methods or helper functions or any operations that do not need the access to instance data.
- static nested class: can be access using the outer class name. often used when a class is closely related to outer class but does not need access to non-static members from outer class.

---

## Q9: What is the differences between overriding and overloading?

- overloading: we could have multiple methods with same name but with different parameters within the same class.
- overriding: provides different implementation of a method in a subclass that is already defined in super class.

---

## Q10: What is the differences between super and this?

- super: refers to super class of current class
- this: refers to current class

---

## Q11: What is the Java load sequence?
class load -> static field and block -> super class -> instance field and block -> constructor

---

## Q12: What is Polymorphism ? And how Java implements it ?
allow objects from different classes to have a common superclass or interface.
Java achieves polymorphism by method overloading and method overriding.

---

## Q13: What is Encapsulation ? How Java implements it? Why we need encapsulation?

encapsulation is to control access to data and methods by using a Java class. Java implements it by using classes, access modifiers (set field to private and can only acquire or modify by getter and setter), and getter & setter methods.
The main goal we use encapsulation is for data security and maintainability.


---

## Q14: What is Interface and what is abstract class? What are the differences between them?

- Interface is a reference type that defines a set of abstract methods (without implementation) and constants
- Abstract class is a class that contains both abstract methods and non-abstract methods.
- we implement interface but extend abstract class, so we can implement multiple interfaces but just one abstract class
- interface can be initialized while abstract class cannot (but it can be subclass to create objects)
- interface can have default methods while abstract cannot
- interface class cannot have constructor while abstract can
- interface can only have constant variable while abstract class can have instance variable

---

## Q16: What are Queue interface implementations and what are the differences and when to use what?

- LinkedList: implements both queue and deque in Java. we use it when we need efficient insertion and delete on both ends.
- PriorityQueue: elements are ordered in natural order or comparator, and we use it when we need to process value in order.
- ArrayDeque: similar to LinkedList and we use when need insertion and delete on both ends, but this is resizable array implementation with higher efficiency but cannot process null value.
- ConcurrentLinkedQueue: thread safe queue, we use it when we need a thread safe queue.
- ArrayBlockingQueue: thread safe and with fixed capacity, we use when we need a fixed capacity queue and thread safe.
- LinkedBlockingQueue: thread safe and implemented based on link node, we need when we need thread safe and dynamic size blocking queue.

---





 


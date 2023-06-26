# HW2

## 1.

- encapusulation:

  ```java
      public class Employee {
          private String name;
          private int age;
          private double salary;
      }
  ```

- inheritance:

  ```java
      public class Manager extends Employee {
          private double bonus;
      }
  ```

- polymorphism:

  ```java
      public class Employee {
          public void work() {
              System.out.println("Employee work");
          }
      }
      public class Manager extends Employee {
          @Override
          public void work() {
              System.out.println("Manager work");
          }
      }
  ```

## 2.What is wrapper class in Java and Why we need wrapper class?

Integer, Double, Float, Long, Short, Byte, Character, Boolean
To convert primitive data types into objects, we use wrapper classes.

## 3. What is the difference between HashMap and HashTable?

- HashMap is not synchronized, while Hashtable is synchronized.
- HashMap allows one null key and multiple null values, while Hashtable doesn’t allow any null key or value.
- HashMap is preferred over HashTable if thread synchronization is not needed

## 4. What is String pool in Java and why we need String pool?

When a string is created and if the string already exists in the pool, the reference of the existing string will be returned. We can force to create a new string object in the heap area using new String(). For memory and string manipulation efficiency.

## 5. What is Java garbage collection?

Distinguish objects by generation to delete unsed objects and preserve long-lived objects.

## 6. What are access modifiers and their scopes in Java?

- public: accessible everywhere
- protected: accessible in the same package and subclasses
- default: accessible in the same package

## 7. What is final key word? (Filed, Method, Class)

- final field: cannot be changed
- final method: cannot be overridden
- final class: cannot be inherited

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

- static field, method: belongs to the class, not to the object
- static class: nested class
  We use it when the method or field are expected to be shared by all objects of the class.

## 9. What is the differences between overriding and overloading?

- Overriding: same method name, same parameter, different implementation
- Overloading: same method name, different parameter

## 10. What is the differences between super and this?

- super: refers to the parent class
- this: refers to the current class

## 11. What is the Java load sequence?

- static block
- constructor block
- non static block

## 12. What is Polymorphism ? And how Java implements it ?

overloading and overriding.
Java implement overloading by different parameter list with same method name.
Java implement overriding by same method name and parameter list, but different implementation in parent and child class.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Hiding data by restricting access to the class.
Java implements it by using private, public, protected, default.
We need encapsulation to protect data from being modified by other classes.

## 14. What is Interface and what is abstract class? What are the differences between them?

- Interface: all methods are abstract, all fields are public static final
- Abstract class: can have abstract methods and non-abstract methods, can have fields

## 15. design park lot under codingQuestion folder

ref: https://www.javatpoint.com/parking-lot-design-java

## 16. What are Queue interface implementations and what are the differences and when to use what?

- LinkedList: FIFO
- PriorityQueue: FIFO, sorted
- ArrayDeque: FIFO, LIFO

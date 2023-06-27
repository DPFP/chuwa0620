# Hw1

### 1.Write up Example code to demonstrate the three foundmental concepts of OOP.
1.Polymorphism
```
class Car{
    public void horn(){
        System.out.println("Car horn raised.")
    }
}

class Suv extends Car{
    @Override
    public void horn(){
        System.out.println("SUV horn raised.")
    }
}
```

2.Inheritance
```
class Car{
    protected String type;

    public void horn(){
        System.out.println("Car horn raised.")
    }
}

class Suv extends Car{
    private String brand;

    public Car(String brand, String type){
        this.brand = brand;
        this.type = type;
    }

    @Override
    public void horn(){
        System.out.println("SUV horn raised.")
    }
}
```

3. Encapsulation:
```
public class Car{
    private String type;
    private String brand;

    public String getType(){
        return type;
    }

    public String getBrand(){
        return brand;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }    

    public void horn(){
        System.out.println("Car horn raised.")
    }
}
```

### 2. What is wrapper class in Java and Why we need wrapper class?
Wrapper class is used to provide a way to represent primary data types to object data type. Wrapper class is used when object types need to be used but not primary data type, for example, ArrayList only store object.

### 3. What is the difference between HashMap and HashTable?
HashMap is not synchronized which is not thread-safe, HashTable is synchronized which is thread-safe. However, hashmap is more efficient than hashtable.

### 4. What is String pool in Java and why we need String pool?
String pool is a storage area in Java heap which literals stores. By default, it is empty and privately maintained by Java String class. We need String pool because it can provide string reusability: when another string with same literal of a current string in the string pool is created, it will refer to the same instance in the string pool.

### 5. What is Java garbage collection?
Java garbage collection is an automatically memory management feature in JVM. It allocate and release memory for Java objects. The aims of Java garbage collection are memory recycle, automatically memory management, and performance optimization.

### 6. What are access modifiers and their scopes in Java?
Access modifiers are used for controlling visibility and accessibility of classes, method, variables. They are:
1.public: allow unrestricted access to a class by other classes and packages
2.private: allow access within the same class
3.protected: allow access within the same class, subclasses, and other class in the same package.

### 7. What is final key word? (Field, Method, Class)
1.Field: final field's value can not be changed, acted as an constant
2.Method: final method can not be override in subclasses
3.Class: final class can not be subclass

### 8. What is static keyword? (Field, Method, Class). When do we usually use it?
1.Field: static field is a field that has the same value for all the instance of the class
2.Method: static method is a method that belong to the class itself, it can be invoke withpout creating an instance of the class
3.Class: static class is when we use nested class, it means this class is independent of any instance of the outer class

### 9.What is the differences between overriding and overloading?
Overloading is the same method name but with different parameters in the same class, it is implemented in compile time. Overriding is the same method signature in the super classes and child classes, it is implemented in runtime. 

### 10. What is the differences between super and this?
Super is used to refer a parent class of a subclass. This is used to refer the instance of the current class.

### 11. What is the Java load sequence?
It is the order of different components of a Java program are loaded and initialized. It usually include Loading, Linking, and Initialization.

### 12. What is Polymorphism ? And how Java implements it ?
Polymorphism is the concept that allow objects of different classes to be treated as onjects with same superclass or interface. Java implement it by using overriding and overloading.

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is the concept that combines data and methods into a unit, it provide interface to interact with the object but hide the internal details. Java implement it by Access Modifiers and getters and setters. We need encapsulation for data security protection, code organization and maintenance and code flexibility and reuseability.

### 14. What is Interface and what is abstract class? What are the differences between them?
Interface is a Java collection of abstract methods and constants, abstract class is a class that server as a base of other class. The difference are:
1.interface do not have implementations, abstract class contain abstract and non-abstract methods
2.abstract class allow different access modifiers, interface are implicitly public
3.abstract class allow constructors but interface don't

### 16. What are Queue interface implementations and what are the differences and when to use what?
1.LinkedList: LinkedList class in Java implements the Queue interface and provide dynamic data structure that allow insertion and deletion on both end.
2.PriorityQueue: PriorityQueue class in Java implements the Queue interface and is implemented as a binary heap, provide insertion and deletion on the root element
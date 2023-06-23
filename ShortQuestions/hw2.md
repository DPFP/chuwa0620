# 1. Demonstrate 3 foundamental concepts of OOP
## Encapsulation
To hide the data access ability from outter visitors. Leave standard access methods instead. 
```
class User{
    private String id;
    private String password;

    User(String id, String password){
        this.id = id;
        this.password = password;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
```

## Polymorphism
Different objects react differently when called the same function.
```
class Human{
    public void work(){
        System.out.println("Working");
    }
}
```
```
class Teacher extends Human{
    @override
    public void work(){
        System.out.println("Teaching");
    }
}
```
```
class Postman extends Human{
    @override
    public void work(){
        System.out.println("Delivering");
    }
}
```
```
class Main{
    public static void main(String [] args){
        Human a = new Teacher();
        Human b = new Postman();
        a.work();
        b.work();
    }
}
```
```
Output: 

Teaching
Delivering
```

## Inheritance
By inheriting from parent class, a child class gain its super class's non-private argument and functions.
```
class A{
    public int a = 1;
    public void func(){
        System.out.println(2);
    }
}
```
```
class B extends A{
    B(){
        this.a = 1;
    }
    public int b = 3;
}
```
```
class Main{
    public static void main(String [] args){
        B b = new B();
        System.out.println(b.a);
        b.func();
    }
}
```
```
Output: 

1
2
```

# 2. What is wrapper class and why?
Wrapper classes in Java are used to convert primitive data types into objects, enabling us to apply object-oriented features, work with collections and generics, utilize utility methods, and handle null values.

# 3. What is the difference between HashMap and HashTable?
HashTable is synchronized and thread-safe, yet less efficient in performance compared with HashMap, which doesn't support synchronization. 

# 4. What is String pool in Java and why we need String pool?
The string pool is a specific memory area in the Java heap that stores a pool of string objects. 

When strings are created using string literals, Java would then checks the string pool to see if a same string already exists. If it does, the existing string object is reused instead of creating a new one. Therefore using string pool provides memory efficiency and performance benefits.

# 5. What is Java garbage collection
Java garbage collection is an automatic process that frees memory occupied by unused objects, eliminating the need for manual memory management.

# 6. What are access modifiers and their scopes in Java
- public: whole scope
- default: within the same package
- protected: within the same package and its subclass
- private: within the class

# 7. What is final key word? (Field, Method, Class)
Field: the field's value cannot be changed once it has been assigned

Method: the method cannot be overridden by subclasses.

Class: the class cannot be subclassed.

# 8. What is static keyword? (Field, Method, Class). When do we usually use it?
Field: Static fields are initialized once and can be accessed directly using the class name without creating an instance of the class.

Method: The method belongs to the class and can be invoked directly using the class name, without the need to create an instance of the class.

Class: The inner class is a static nested class. It means the nested class is not tied to an instance of the outer class and can be accessed using the outer class name.

# 9. What is the differences between overriding and overloading?
- Overriding: To change the behaviors of functions inherited from super class, by re-implementing a function with the same function name and parameters.
- Overloading: To extend a function's availability by defining and implementing one or more functions with same name but different type or number of parameters.

# 10. What is the differences between super and this
- super: parent class of current class
- this: current class

# 11. What is the Java load sequence?
1. load class
2. allocate memory for static fields
3. linking the symbolic references to their corresponding memory addresses or constant pool entries
4. executing the static initialization blocks and initializing the static fields of the class

# 12. What is Polymorphism ? And how Java implements it ?
Polymorphism in Java allows objects of different classes to be treated as objects of a common superclass. It is achieved through inheritance and method overriding. Objects can exhibit different behaviors based on their specific types or the context in which they are used.

# 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation in Java is the practice of combining data and methods into a single unit and controlling access to the data through public methods. It is implemented by 'class'. It hides internal details, promotes code organization and reusability, and enhances data security and validation.

# 14. What is Interface and what is abstract class? What are the differences between them?
A class can only extend one abstract class. In contrast, a class can implement multiple interfaces.

An abstract class can have a constructor, and it can be called by subclasses. Interfaces, however, cannot have constructors.

An abstract class can have both abstract and non-abstract methods. It can provide default implementations for some methods and leave others abstract. In contrast, an interface can only have abstract methods and constants.

# 16. What are Queue interface implementations and what are the differences and when to use what?
- **LinkedList**: It allows elements to be added and removed from both ends efficiently. LinkedList is a good choice when you need to frequently add or remove elements from both the front and back of the queue.

- **ArrayDeque**: It provides better performance than LinkedList in most cases and does not require resizing as frequently. It is recommended to use ArrayDeque as a general-purpose queue implementation when you don't require concurrent access.

- **PriorityQueue**: It allows elements to be inserted in any order but retrieves them in a specific order defined by their natural ordering or a custom Comparator. PriorityQueue is suitable when you need to process elements based on their priority or order.
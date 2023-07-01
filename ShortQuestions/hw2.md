###HW2

2. Wrapper class provides a way to use primitive type as objects. eg. The wrapper class of int is Integer
   We must use wrapper class when working with Collection objects, because Collection can only store objects. 
3. HashMap
   -Not thread-safe
   *Allows NULL key (but only allows 1)
   +Better performance
   HashTable
   -Thread-safe
   *No NULL key is allowed
   +Lower performance
4. String pool in Java is a memory space in Java heap memory where String is stored. When we create a new String object using syntex "String s = "" ", JVM will first checks the String Constant Pool before creating a new String object corresponding to it.
   String pool decreases the number of String object in memory.
   String is immutable because strings with the same content share storage in a single pool to minimize creating a copy of the same value.
5. Java GC means JVM automatically free up memory that is no longer used or needed.
6. Default: declaration are visible only within the package
   Private:visible only within the class
   Protected: visible only within the package or all subclasses
   Public: visible everywhere
7. Final
   Class: The class can't be extended or inherited and is immutable
   Method: can't be override
   Variable: define constant, the value can't be changed.
8. static
   variable: The variable belongs to the class rather than each instance of the class. There's only one copy of the variable in memory. We can access it through ClassName.VarialeName
   Method: We can call a static method using class name
   Class: a static class must be a nested class. An instance of a static class can be created without creating an instance of outer class. A static class can not access to the non-static members of outer class
9. Override
    -Happens during class inheritance
    *Same method signature, i.e. same name and method parameters
    +Method call is determined at runtime
    Overload
    -Happens in the same class
    *Method names are the same but with different method parameters. E.g. constructor overloading.
    +Method call is determined at compile time
10. super is used to refer to members of parent class. this is used to refer to members of current class
11. Static block/variable is loaded before constructor when we creating an instance
12. polymorphism refers to the same object exhibiting different forms and behaviors.
    Static Polymorphism - Overload (same class) - compile time
    Dynamic Polymorphism - Override (child class) - run time
13. Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).
    eg. Getter/Setter (methods)
    By bundling data and methods into one abstracted unit, encapsulation hides complex, lower-level data. It can prevent unwanted access to sensitive data and hide information through access modifiers while also reducing erroneous human changes.
14. Abstract class 
    -Normally has a mixture of abstract and non-abstract methods. These methods can be public / protected / private
    *Doesn’t support multiple inheritance
    *Allow final, static, and non-static variables
    +Can implement an interface
    Interface
    -Normally has only abstract and public methods. Interface has started supporting default and static methods since java 8, which are allowed to be implemented in the interface.
    *Support multiple inheritance
    *Only allow static and final variables
    +Can’t extends an abstract class
16. We can check [Queue Interface](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
    
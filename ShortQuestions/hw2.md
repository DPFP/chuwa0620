# 1
1. Encapsulation
```
public class Test{
	private String userName;
	private String password;

	public String getName(){
		return userName;
	}

	public String setName(String name){
		userName = name;
	}

	public String getPW(){
		return userName;
	}

	public String setPW(String pw){
		userName = name;
	}
}
```

2. Polymorphism
```
	class Animal{
		public String name;
		public int age;
		public void shout() {
			System.out.println("aaa");
		}
	}
	
	class cat extends Animal{
		@Override
		public void shout() {
			System.out.println("meow");
		}
	}
```

3. Inheritance
```
	class Animal{
		public String name;
		public int age;

	}
	
	class cat extends Animal{

		public void shout() {
			System.out.println("meow");
		}
	}
```

# 2
Wrapper classes provide a way to use primitive data types ( int , boolean , etc..) as objects.  
Wrapper classes helps Java be completely object-oriented.  

# 3
HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.  
HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.  
HashMap is generally preferred over HashTable if thread synchronization is not needed.  

# 4
String Pool in java is a pool of Strings stored in Java Heap Memory.  
It is created to decrease the number of string objects created in the memory.  

# 5
Garbage collection in Java is the automated process of deleting code that's no longer needed or used. This automatically frees up memory space and ideally makes coding Java apps easier for developers.  

# 6
Access modifiers are object-oriented programming that is used to set the accessibility of classes, constructors, methods, and other members of Java.  
Default: declarations are visible only within the package (package private)  
Private: declarations are visible within the class only  
Protected: declarations are visible within the package or all subclasses  
Public: declarations are visible everywhere  

# 7
variable: cannot change the value of final variable
method: cannot override it
class: cannot extend it

# 8
When a variable is declared as static, then a single copy of the variable is created and shared among all objects at the class level  
When a method is declared with the static keyword, it is known as the static method  
A static class is a class that is created inside a class, is called a static nested class in Java  

# 9
Override:  
Implements “runtime polymorphism”  
The method call is determined at runtime based on the object type  
Occurs between superclass and subclass  
Have the same signature (name and method arguments)  

Overload:  
Implements “compile time polymorphism”  
The method call is determined at compile time  
Occurs between the methods in the same class  
Have the same name, but the parameters are different  

# 10
this keyword points to the class itself while keyword super points to the father class  

# 11
static variable/block -> constructor  
The Java load sequence is the order in which the JVM loads and initializes the parts of a Java program, starting with class files, linking, initializing variables and static blocks, and ending with the main method starting execution.

# 12
In Java, polymorphism refers to the ability of a class to provide different implementations of a method, depending on the type of object that is passed to the method. It is implemented by inheritance and overriding

# 13
Encapsulation in Java is a powerful mechanism for storing the data members and data methods of a class together. It is done in the form of a secure field accessible by only the members of the same class. It is implemented by the modifiers in the class.

# 14
A class that is declared as abstract is known as an abstract class. It needs to be extended and its method implemented. It cannot be instantiated. It can have abstract methods, non-abstract methods, constructors, and static methods. It can also have the final methods which will force the subclass not to change the body of the method.  

The interface is a blueprint for a class that has static constants and abstract methods. It can be used to achieve full abstraction and multiple inheritance. It is a mechanism to achieve abstraction. There can be only abstract methods in the Java interface, not method body. It is used to achieve abstraction and multiple inheritance in Java.  

An abstract class can have a method body (non-abstract methods), instance variables, the constructor and the static methods.  
The interface has only abstract methods. An interface cannot have instance variables, the constructor and the static methods.

# 16
The Queue interface is present in java.util package and extends the Collection interface is used to hold the elements about to be processed in FIFO(First In First Out) order.  
The difference between PriorityQueue and Linkedlist is at the time of insertion PriorityQueue will be sorted as well as ordered as per the natural order but we can add a Commparator also in order to define the particular order of sorting for a record, while as LinkedList will be just ordered by the order of insertion.

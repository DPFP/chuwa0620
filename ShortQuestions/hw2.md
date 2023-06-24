1. 

   ```java
   class People{
     private int height;
     
     public int getHeight(){
       return this.height;
     }
     
     public int setHeight(int height){
       this.height = height;
     }
     
     public void speak(){
       System.out.println("I am a human");
     }
   }
   
   class Teacher extends People{
     @Override
     void speak(){
       System.out.println("I am a teacher")
     }
   }
   
   class Student extends People{
     private int age;
     private String name;
     private long id;
     
     public int getAge(){
       return this.age;
     }
     public void setAge(int age){
       this.age = age;
     }
     
     public String getName(){
       return this.name;
     }
     public void setName(String name){
       this.name = name;
     }
     
     public long getId(){
       return this.id;
     }
     
     public void setId(long id){
       this.id = id;
     }
     @Override
     void speak(){
       System.out.println("I am a student")
     }
   }
   
   public static void main(String[] args){
     People teacher = new Teacher();
     People student = new Student();
     
     teacher.speak();
     student.speak();
   }
   ```

2. Wrapper class is a method that Java provides that allow developer to use primitive type as an object. 

   1. Most common reason what we need a wrapper class is because that Java Collections like ArrayList can only accpet object as value. 
   2. Also wrapper class provides some utility functions.
   3. Wrapper class can be assigned with a null value whereas primitive type cannot.

3. Difference between HashMap and HashTable in Java

   1. HashMap function is non-synchronized, HashTable function is synchronized.
   2. MultipleThread can operate simultaneously in HashMap, but it is not thread safe. HashTable can only allow one thread to operate at a time so it is thread-safe.
   3. HashMap has better performance than HashTable.
   4. HashMap accept Null value as key or value. HashTable cannot accept Null value as value nor key.

4. String Pool in java is a pool of Strings stored in Java Heap Memory.It is created to decrease the number of string objects created in the memory. Whenever a new string is created, JVM first checks the string pool. If it encounters the same string, then instead of creating a new string, it returns a reference existing string to the variable.

5. Garbage collection in Java is the automated process of deleting code that's no longer needed or used. This automatically frees up memory space and ideally makes coding Java apps easier for developers. Unlike C and C++ where developer needs to free up memory to prevent memory leak, jvm dose this for the developer.

6. There are 4 types of access modifier in Java

   1. Default: It is implicit in Java, when no access modifier is specified, default is enable which mean class, data, or method can only be accessed within the same package.

   2. Private: Can only be accessed within the class.

   3. Protected: Can be accessed within the same package or subclass in other package.

   4. Public: Can be accessed from everywhere within the program.

      

7. Final keyword in Java has different meanings when it was used on variable, method, and class
   1. Variable: Constant variable cannot be changed.
   2. Method: Cannot be override
   3. Class: Cannot be inherited.
8. Static keyword in java in Java indicates that a particular member is not an instance, but rather part of a type. Also when JVM starts the initilize the class, static part will have relative higher priority.
9. Overriding means subclass rewrite the function of super class with different implementation. Overloading means implementing method with same name but different signature.
10. super keyword means accessing field or method in parent class whereas this means accessing field or method in current class.
11. Java class loading sequence
    1. Application classloader accepts the class loading request and delegated request to extendsion and bootstrap class loader.
    2. Bootstrap ClassLoader will search in the Bootstrap classpath(JDK/JRE/LIB). If the class is available then it is loaded, if not the request is delegated to Extension ClassLoader.
    3. Extension ClassLoader searches for the class in the Extension Classpath(JDK/JRE/LIB/EXT). If the class is available then it is loaded, if not the request is delegated to the Application ClassLoader.
    4. Application ClassLoader searches for the class in the Application Classpath. If the class is available then it is loaded, if not then a **ClassNotFoundException** exception is generated.
12. Polymorphism means we have many class relate to each other by method of inheritance, which means child class and access the field and method in parent class by inheriting them.
13. Encapsulation is a method that helps developer to keep data integrity, data is hidden and can only be accessed or modified using specified method. In java we use private keyword to the variable and create getter and setter function for them.
14. 
    1. interfaceis is used to group related methods with empty bodies and defines the class for usage
    2. Abstract class: is a restricted class that cannot be used to create objects
    3. An abstract class is a class that cannot be instantiated and can contain both abstract and non-abstract methods. An interface, on the other hand, is a contract that specifies a set of methods that a class must implement
15. See codingQuestions/coding1 for detail
16. The Queue interface is present in java.uti lpackage and extends the Collection interfaceis used to hold the elements about to be processed in FIFO(First In First Out) order. It is an ordered list of objects with its use limited to inserting elements at the end of the list and deleting elements from the start of the list, (i.e.), it follows the FIFO or the First-In-First-Out principle.
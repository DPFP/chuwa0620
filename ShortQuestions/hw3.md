1. 

2. 
   1. Checked exception are those exceptions to be checked at the compile stage of the program. For example like IOException or Filenotfound exception.
   2. Unchecked exception is subclass of Runtime exception which can only be detected and throw after compiled stage. For example like dividedByZeroException.
3. There can only be one finally block and it must follow the catch blocks.

4. Only the finally value will be return since finally block will be last block of a function.
5. 
   1. Checked exception are those exceptions to be checked at the compile stage of the program. For example like IOException or Filenotfound exception.
   2. Unchecked exception is subclass of Runtime exception which can only be detected and throw after compiled stage. For example like dividedByZeroException.
6. throw is a keyword to throw a certain exception while throws keyword is used as signature of a method telling compiler what kind of exception current function might throw.

7. Since runtime exception is subclass of Exception, if we catch exception first, subclass will not be handled.
8. The reason why finally block will be executed is because when Java compiler compiles the java file to bytecode, it will copy  whatever inside the finally block and then paste them inside both try and catch block so that finally block will always be executed.
9. Design pattern in java can be split into 3 major parts, creational, structual and behavioral.
10. SOLID is abbreviation of 5 major design principle
    1. Single responsibility principle
    2. Open-closed principle
    3. Liskov Substitution principle
    4. Interface segregation principle
    5. Dependency Inversion principle
11. To achieve thread-safe singleton, there are two ways.
    1. Use eager loading, initilize the singleton while loading the class.
    2. Synchronize the getInstance() method.
    3. Use synchronized block inside if loop and volatile variables.
12. Entities should be open to extension and closed to modification this will mitigate the risk of introducing new feature to the existing program.

13. It means if a method is present in class A, it should also be present in class B so that the object of 
    type B could substitute object of type A.
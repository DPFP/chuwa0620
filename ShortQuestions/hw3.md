2.  What is the checked exception and unchecked exception in Java, could you give one example?
    checked exceptions are compile time exceptions, such as IOException and ClassNotFoundException, you need to handle it by using try catch or throws.
    unchecked exceptions are runtime exceptions, such as NPE, OutOfBoundExceptions

3.  Can there be multiple finally blocks
    yes
4.  When both catch and finally return values, what will be the final result ?
    whatever we have in the finally block
5.  What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
    checked exceptions are compile time exceptions, such as IOException and ClassNotFoundException, you need to handle it by using try catch or throws.
    unchecked exceptions are runtime exceptions, such as NPE, OutOfBoundExceptions
6.  What is the difference between throw and throws ?
    they are both java keywords,
    throws : used in method declarations tells that the method might throw some exceptions
    throw : use within method body to throw an exception
7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
    exception before Exception ?
    we always should put the child Exception
7.  Why finally always be executed ?
    In summary, the "finally" block is designed to ensure that specific code is executed regardless of any exceptions that may occur in the preceding try-catch block, making it a useful construct for managing resources and maintaining program stability.
8.  What are the types of design patterns in Java ?
    Creational, Behavioral, Structural
9.  What are the SOLID Principles ?
    Single Responsibility,
    Open-Closed Principle
    Liskov Substitution
    Interface segregation
    Dependency Inversion
10.  How can you achieve thread-safe singleton patterns in Java ?
     class OptimizedLazySingleton{
     // use volatile here to avoid the situation that instance might points to null
     //1. create instance reference
     //2. new singleton()
     //3. instance reference pints to instance object
     //jvm might do 1 3 2 here so instance could be null still
     private static volatile OptimizedLazySingleton instance;
     private OptimizedLazySingleton(){};


public static OptimizedLazySingleton getInstance(){
if(instance == null){
//we use synchronized to lock the class here so that only one thread can access the code block at a time
synchronized (OptimizedLazySingleton.class){
//double check if the instance is null here bc we might have a T2 that initialize the instance already
if (instance == null) instance = new OptimizedLazySingleton();
}
}
return instance;
}
}

11.  What do you understand by the Open-Closed Principle (OCP) ?
     Software entities (classes, modules, functions, etc.) should be open for extension but closed for 
    modification. It promotes the idea of designing software components in a way that allows them to be easily extended with new behavior without modifying their existing code.
12. 1
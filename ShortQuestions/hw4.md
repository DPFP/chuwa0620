### 1 What is generic in Java?
Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types) to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types.

### 5 Write the Singleton design pattern include eager load and lazy load.
eager load
```
public class Singleton{
  private static Singleton instance = new Singleton();

  private Singleton(){
  }

  public static Singleton getInstance(){
    return instance;
  }

}
```

lazy load
```
public class Singleton{
  private Singleton(){
  }

  private static class SingletonHolder{
    private static final Singleton INSTANCE = new Singleton();
  }

  public static Singleton getInstance(){
    return SingletonHolder.INSTANCE;
  }
}
```

### 6 What is Runtime Exception? could you give me some examples?
RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine.  
An object that is expected to have a value but is actually null. In this case, a NullPointerException exception would be thrown.  
ArrayIndexOutOfBoundsException will be thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array.

### 7 Could you give me one example of NullPointerException?

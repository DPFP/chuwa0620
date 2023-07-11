#### 1. Explain volatile variables in java? (we also use it in Singleton)

The volatile keyword in Java is used to indicate that a variable's value may be modified by multiple threads simultaneously. It ensures that the variable is always read from and written to the main memory, rather than from thread-specific caches, ensuring visibility across threads.

#### 2. how to create a new thread(Please also consider Thread Pool case)?

- extends thread
- implement runnable
- implement callable
- use executor

#### 3. Difference between Runnable and Callable

Callable has return and throws exception, while runable doesn't have

#### 4. what is the diff between t.start() and t.run()?

- t.start() starts a new thread to execute the task（run()）
- t.run() executes the task in the current thread.

#### 5. Which way of creating threads is better: Thread class or Runnable interface?

Runnable interface

Because implementing Runnable interface we can extends any other class. If we extends thread class, there is no chance of extending any other class.

#### 6. what is the thread status?

==new==: Thread state for a thread that has not yet started. 

==runnable==:   After the invocation of the start() method, the thread is in Runnable state. Might be running or ready to run 

==Blocked==: when it is waiting for a monitor lock

==waiting==: when it is waiting for another thread to perform a particular action

==Timed waiting==: when it is waiting for another thread to perform an action for up to a specified waiting time.

==Terminated==:  A thread is in this state when its run() method exits.

#### 7. difference between wait() and sleep() method

wait() releases the lock or monitor while sleep() doesn't releases the lock or monitor while waiting. wait() is used for inter-thread communication while sleep() is used to introduce pause on execution, generally

#### 8. What is deadlock?

Deadlock occurs when multiple threads need the same locks but obtain them in different order.

#### 9. how do threads communicate with each other?

wait()、notify()和notifyAll()

#### 10. what is join() method?

Allows one thread to wait until another thread completes its execution. 

t. join() will make sure that t is terminated before the next instruction is executed by the program

#### 11. what is yield() method

A yield() method is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority. If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution.

#### 12. Explain thread pool

A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing

#### 13. What is Executor Framework in Java, its different types and how to create these executors?

The[ java.util.concurrent.Executors](https://www.geeksforgeeks.org/java-util-concurrent-executor-interface-with-examples/) provide factory methods that are being used to create [ThreadPools](https://www.geeksforgeeks.org/thread-pools-java/) of worker threads. 

- SingalThreadPool:

  - execute tasks sequentially.

  - ```
    ExecutorService executor = Executors.newSingleThreadExecutor();
    ```

- FixedThreadPool：

  - a thread pool of a fixed number of threads. 

  - ```
    ExecutorService fixedPool = Executors.newFixedThreadPool(2);
    ```

- CachedThreadPool：

  - creates new threads as needed, but will reuse previously constructed threads when they are available.

  - ```
    ExecutorService executorService = Executors.newCachedThreadPool();
    ```

  

#### 14. Difference between shutdown() and shutdownNow() methods of executor

The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.

#### 15. What is Atomic classes? when do we use it?

Atomic classes in Java are part of the `java.util.concurrent` package and are used in multithreaded environments. These classes support **lock-free and thread-safe** programming on single variables

- AtomicBoolean
- AtomicInteger
- AtomicLong
- AtomicReference

These operations are crucial in multithreaded environments to prevent race conditions. For example, if you have a counter variable that's incremented by multiple threads, you should use AtomicInteger instead of int to ensure the counter is incremented safely without missing any updates due to concurrent thread interference.

#### 16. What is the concurrent collections?

concurrent collections are thread safe version compared with normal collections

#### 17. what kind of locks you know?

- ReentrantLock
- Synchronized
- ReadWriteLock
- StampedLock

#### 18. What is the difference between class lock and object lock?

object lock = individual instance, class lock = entire class.

**Object Lock**: Synchronizes on `this` or an instance of a class. Different instances can run locked methods simultaneously, because each instance has its own lock.

**Class Lock**: Synchronizes on the class itself using a `static` method or `synchronized (MyClass.class)`. Only one thread can run locked static methods at a time, regardless of how many instances exist.

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230708155708211.png" alt="image-20230708155708211" style="zoom:50%;" />

```Java
public class Test {

    // 对象锁
    public synchronized void instanceMethod() {
        // 只有一个线程可以访问该实例的这个方法
    }

    // 类锁
    public static synchronized void staticMethod() {
        // 只有一个线程可以访问这个类的这个方法
    }
}

public class Main {
    public static void main(String[] args) {
        Test instance1 = new Test();
        Test instance2 = new Test();

        // 创建一个线程访问instance1的instanceMethod
        new Thread(() -> instance1.instanceMethod()).start();

        // 创建另一个线程访问instance2的instanceMethod，这是允许的，因为instance1和instance2是两个不同的对象，所以它们各自拥有自己的对象锁
        new Thread(() -> instance2.instanceMethod()).start();

        // 创建一个线程访问Test类的staticMethod
        new Thread(() -> Test.staticMethod()).start();

        // 创建另一个线程访问Test类的staticMethod，这是不允许的，因为staticMethod是静态的，这意味着它持有的是一个类锁，无论创建了多少个实例，任何时刻只有一个线程可以访问这个方法。
        new Thread(() -> Test.staticMethod()).start();
    }
}

```



#### 19. What is future and completableFuture?

**Future:**

A `Future` is typically used with a `ExecutorService` to run a Callable task:

```Java
ExecutorService executorService = Executors.newSingleThreadExecutor();

Future<Integer> future = executorService.submit(() -> {
    Thread.sleep(1000);
    return 5;
});

// Do something else while waiting...

try {
    Integer result = future.get();  // this will block until the future completes
    System.out.println(result);
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

executorService.shutdown();

```

In this example, `future.get()` will block and wait until the Callable completes, then it returns the result.

**CompletableFuture:**

`CompletableFuture` is typically used to chain multiple asynchronous operations:

```Java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new IllegalStateException(e);
    }
    return 5;
});

// Then apply a Function on the result of the previous stage.
CompletableFuture<Integer> futurePlus10 = future.thenApply(i -> i + 10);

// Do something else while waiting...

try {
    Integer result = futurePlus10.get();  // this will block until the future completes
    System.out.println(result); // will print 15
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

```

In this example, `future.thenApply(i -> i + 10)` will not block. It returns immediately with a new `CompletableFuture`, which will complete with the result of the function applied to the result of the previous stage. This allows you to chain multiple operations in a non-blocking way.

#### 20. what is ThreadLocal?

ThreadLocal is a special class in Java that helps us achieve thread safety by providing per-thread contexts and maintaining them separately for each thread. In other words, ThreadLocal is a Java class that can be used to define variables accessible solely by the thread that created them

#### 21. Type the code by your self and try to understand it

(packagecom.chuwa.tutorial.t08_multithreading)

Done

#### Code Q1：

write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print
2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

a. One solution use synchronized and wait notify
b. One solution use ReentrantLock and await, signal

```Java
Thread-0: 1
Thread-1: 2
Thread-0: 3
Thread-1: 4
Thread-0: 5
Thread-1: 6
Thread-0: 7
Thread-1: 8
Thread-0: 9
Thread-1: 10
Process finished with exit code 0
```

#### Code Q2 :

create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread
output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)

```Java
Thread-0: 1
Thread-0: 2
Thread-0: 3
Thread-0: 4
Thread-0: 5
Thread-0: 6
Thread-0: 7
Thread-0: 8
Thread-0: 9
Thread-0: 10
Thread-2: 11
Thread-2: 12
Thread-2: 13
Thread-2: 14
Thread-2: 15
Thread-2: 16
Thread-2: 17
Thread-2: 18
Thread-2: 19
Thread-2: 20
Thread-1: 21
Thread-1: 22
Thread-1: 23
Thread-1: 24
Thread-1: 25
Thread-1: 26
Thread-1: 27
Thread-1: 28
Thread-1: 29
Thread-1: 30
```

#### Code Q3 :

completable future:
a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
i. Sign In to Developer.BestBuy.com
ii. Best Buy Developer API Documentation(bestbuyapis.github.io)
iii. 可以⽤fake api https://jsonplaceholder.typicode.com/
c. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.
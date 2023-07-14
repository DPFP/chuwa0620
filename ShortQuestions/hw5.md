## 1. Explain volatile variables in java? (we also use it in Singleton)

Using volatile is useful in scenarios where multiple threads are accessing and modifying a shared variable, as it helps
to prevent unexpected behaviors such as stale or inconsistent values due to caching. However, volatile is not a
substitute for proper synchronization mechanisms like locks or synchronized blocks when dealing with complex operations
or critical sections.

## 2. how to create a new thread(Please also consider Thread Pool case)?

* Using the Thread class:

```java
Thread thread=new Thread(new Runnable(){
public void run(){
        // Code to be executed in the new thread
        }
        });

// Start the thread
        thread.start();
```

* Using a thread pool (specifically, the ExecutorService interface):

```java
ExecutorService executor=Executors.newFixedThreadPool(poolSize);

// Submit a task (as a Runnable or Callable) to the thread pool
        executor.submit(new Runnable(){
public void run(){
        // Code to be executed in the new thread
        }
        });

// Shutdown the thread pool when no longer needed
        executor.shutdown();
```

## 3. Difference between Runnable and Callable

* Return Type:
  Runnable does not have a return type. Its run() method does not return a value.

Callable has a return type specified by its type parameter. Its call() method returns a value.

* Exception Handling:
  Runnable cannot throw checked exceptions directly from its run() method. If an exception occurs within a run() method,
  it must be caught and handled within the method itself.

Callable can throw checked exceptions from its call() method. The exception can be caught and handled by the calling
code.

* Usage with ExecutorService:
  Runnable is commonly used with the ExecutorService interface to submit tasks for execution in a thread pool. The
  ExecutorService invokes the run() method of the Runnable objects.

Callable is also used with the ExecutorService interface, but it returns a Future object that represents the result of
the computation. The Future object can be used to retrieve the result once the computation is complete.

## 4. what is the diff between t.start() and t.run()?

* t.start(): This method is used to start a new thread of execution for the given Thread object (t). When t.start() is
  called, it internally calls the run() method of t in a separate thread. The run() method contains the code that will
  be executed in the new thread. Once start() is invoked, the new thread begins its execution concurrently with the main
  thread or other active threads.
* t.run(): This method does not start a new thread. Instead, it executes the run() method of t in the current thread.
  The code inside run() is executed sequentially, just like a normal method invocation. In this case, there is no
  concurrent execution of multiple threads.

## 5. Which way of creating threads is better: Thread class or Runnable interface?

Overall, the preferred approach depends on the specific requirements and design of your application. If you need
simplicity and direct access to thread-related methods, extending Thread can be a suitable choice. On the other hand, if
flexibility, separation of concerns, and improved resource utilization are important, implementing Runnable is generally
recommended.

## 6. what is the thread status?

* New
* Runnable
* Running
* Blcoked/Waiting
* Timed Waiting
* Terminated

## 7. difference between wait() and sleep() method

wait() is used for synchronization and inter-thread communication, whereas sleep() is used for introducing delays or
pausing the execution of a thread. wait() is invoked on an object within a synchronized block, releases the lock, and
waits for notification, while sleep() is invoked on the Thread class, maintains the lock, and introduces a delay without
any synchronization or specific notification mechanism.

## 8. What is deadlock?

Deadlock is a situation in concurrent programming where two or more threads are blocked forever, waiting for each other
to release resources or locks that they hold. In other words, it is a state where two or more threads are unable to
proceed because each of them is waiting for a resource that is held by another thread in the deadlock set.

## 9. how do threads communicate with each other?

wait() and notify() methods: These methods are part of the Object class and allow threads to wait for a specific
condition to be satisfied and then notify other waiting threads when the condition is met.

The join() method suspends the execution of the calling thread until the joined thread completes its execution.

## 10. what is join() method?

The join() method is a method provided by the Thread class in Java that allows one thread to wait for the completion of
another thread. When a thread calls the join() method on another thread, the calling thread suspends its execution and
waits until the joined thread completes.

## 11. what is yield() method

The yield() method is a method provided by the Thread class in Java that suggests to the scheduler that the current
thread is willing to yield its current execution to allow other threads of the same priority to run

## 12. Explain thread pool

Using a thread pool is generally recommended over manually creating and managing threads, as it provides better resource
management, scalability, and simplifies the task submission and execution process.

## 13. What is Executor Framework in Java, its different types and how to create these executors?

The Executor Framework in Java is a higher-level concurrency framework that provides a standardized way to manage and
execute tasks asynchronously.

* FixedThreadPool
* CachedThreadPool
* SingleThreadExecutor
* ScheduledThreadPool

To create these executors, we can use the Executors class.

```java
// Creating a fixed-size thread pool with 5 threads
ExecutorService executor=Executors.newFixedThreadPool(5);

// Creating a cached thread pool
        ExecutorService executor=Executors.newCachedThreadPool();

// Creating a single-threaded executor
        ExecutorService executor=Executors.newSingleThreadExecutor();

// Creating a scheduled thread pool with 10 threads
        ScheduledExecutorService executor=Executors.newScheduledThreadPool(10);

```

## 14. Difference between shutdown() and shutdownNow() methods of executor

shutdown() allows previously submitted tasks to complete while preventing new tasks from being accepted, and
shutdownNow() attempts to stop the ExecutorService immediately by cancelling pending tasks and interrupting running
tasks. The choice between shutdown() and shutdownNow() depends on the desired behavior and how you want to handle
pending tasks during the shutdown process.

## 15. What is Atomic classes? when do we use it?

Atomic classes in Java, found in the java.util.concurrent.atomic package, provide a way to perform atomic operations on
shared variables without the need for explicit synchronization. They ensure that operations on the variables are
indivisible and thread-safe, even in a concurrent environment.

When to use atomic classes:

* Counters or accumulators: When multiple threads increment or decrement a counter or accumulate values in a shared
  variable.
* Flags or switches: When multiple threads need to check or update a boolean flag or switch.
* Idempotent operations: When you want to perform an operation only once, even if multiple threads attempt it
  concurrently.

## 16. What is the cocurrent collections?

Concurrent collections are specialized data structures provided by the Java Collections Framework that are designed to
be used in concurrent or multi-threaded environments.

* ConcurrentHashMap
* ConcurrentLinkedQueue
* ConcurrentSkipListSet and ConcurrentSkipListMap
* CopyOnWriteArrayList and CopyOnWriteArraySet

## 17. what kind of locks you know?

* ReentrantLock
* ReadWriteLock
* StampedLock
* ReentrantReadWriteLock

## 18. What is the difference between class lock and object lock?

The class lock is used to synchronize access to static synchronized methods or blocks within a class, preventing
concurrent execution of static synchronized code across all instances of the class.

The object lock is used to synchronize access to instance synchronized methods or blocks, ensuring that only one thread
can execute synchronized code on a specific instance at a time.

## 19. What is future and completableFuture?

* Future Future is a core interface introduced in Java 5 as part of the java.util.concurrent package.

It represents the result of an asynchronous computation that may not be available immediately.

A Future object can be used to check if the computation is complete, retrieve the result once it's available, or cancel
the computation if desired.

* CompletableFuture CompletableFuture is an extension of Future introduced in Java 8 as part of the java.util.concurrent
  package.

It enhances the functionality of Future by providing additional features for handling asynchronous computations in a
more flexible and composable manner.

CompletableFuture allows you to chain together a series of asynchronous operations and define callbacks or actions to be
executed upon completion of the computation.

## 20. what is ThreadLocal?

ThreadLocal is a class in Java that provides thread-local variables. It allows you to create variables that are specific
to each thread and are not shared among threads. Each thread accessing a ThreadLocal variable has its own independently
initialized copy of the variable.

## 22. Read those interview questions and pick some important questions to this home work.

### How can we create daemon threads

We can create daemon threads in java using the thread class setDaemon(true). It is used to mark the current thread as
daemon thread or user thread. isDaemon() method is generally used to check whether the current thread is daemon or not.
If the thread is a daemon, it will return true otherwise it returns false.

```java
public class DaemonThread extends Thread {
    public DaemonThread(String name) {
        super(name);
    }

    public void run() {
        // Checking whether the thread is Daemon or not 
        if (Thread.currentThread().isDaemon()) {
            System.out.println(getName() + " is Daemon thread");
        } else {
            System.out.println(getName() + " is User thread");
        }
    }

    public static void main(String[] args) {
        DaemonThread t1 = new DaemonThread("t1");
        DaemonThread t2 = new DaemonThread("t2");
        DaemonThread t3 = new DaemonThread("t3");
        // Setting user thread t1 to Daemon 
        t1.setDaemon(true);
        // starting first 2 threads  
        t1.start();
        t2.start();
        // Setting user thread t3 to Daemon 
        t3.setDaemon(true);
        t3.start();
    }
} 
```

### Can two threads execute two methods (static and non-static concurrently)?

Yes, it is possible. If both the threads acquire locks on different objects, then they can execute concurrently without
any problem.

### What is the purpose of the finalize() method?

Finalize() method is basically a method of Object class specially used to perform cleanup operations on unmanaged
resources just before garbage collection. It is not at all intended to be called a normal method. After the complete
execution of finalize() method, the object gets destroyed automatically.

Multithreading Interview Questions in Java for Experienced

## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

a. One solution use synchronized and wait notify b. One solution use ReentrantLock and await, signal

## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)

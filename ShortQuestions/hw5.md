# 1. Explain volatile variables in java? (we also use it in Singleton)
In Java, the volatile keyword is used as a modifier for variables. When a variable is declared as volatile, it indicates that its value may be modified by multiple threads, and the threads should always read the latest updated value.

# 2. how to create a new thread(Please also consider Thread Pool case)?
### Extending the Thread class:
```
class MyThread extends Thread {
    public void run() {
        // Code to be executed in the new thread
    }
}

MyThread thread = new MyThread();
thread.start();
```
### Implementing the Runnable interface:
```
class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed in the new thread
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();
```
### Using Callable and Future with ExecutorService:
```
class MyCallable implements Callable<Integer> {
    public Integer call() {
        // Code to be executed in the new thread
        return 42; 
    }
}

ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(new MyCallable());
try {
    Integer result = future.get();
    System.out.println("Result: " + result);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    executor.shutdown();
}
```

### Using a thread pool with ExecutorService:
```
ExecutorService executor = Executors.newFixedThreadPool(5);

executor.execute(new Runnable() {
    public void run() {
        // Code to be executed in a new thread
    }
});

executor.shutdown();
```
# 3. Difference between Runnable and Callable
Runnable has no return value.

# 4. what is the diff between t.start() and t.run()?
t.start() will start a new thread and execute t.run()

t.run() means current thread to run the block inside.

# 5. Which way of creating threads is better: Thread class or Runnable interface?
 Runnable interface is a better way. It's more flexible. You can still extend other classes and implement other interfaces in this way. Also, by implementing Runnable and override run(), it promotes better separation of concerns and adheres to the principle of single responsibility.

 # 6. What is the thread status?
 New, Runnable, Blocked/Waiting, Timed Waiting, Terminated

 # 7. difference between wait() and sleep() method
 The wait() allows a thread to voluntarily give up its lock on an object and enter a waiting state until another thread notifies it to resume.

The sleep() method is used to pause the execution of a thread for a specified duration, providing a simple form of time delay. It does not release any locks or monitor resources.

# 8.  What is deadlock?
Different processes all hold certain resource while waiting for resources held by other processes to continue. When the waiting queue forms a loop, deadlock happens. 

# 9.  how do threads communicate with each other?
- Use shared memory of their mutual process.
- Message passing using BlockingQueue
- Signals and conditions

# 10. what is join() method?
The join() method is a method available in the Thread class in Java. It allows one thread to wait for the completion of another thread before proceeding. When a thread calls the join() method on another thread, it blocks until the other thread completes its execution.

# 11. what is yield() method
The yield() method is a static method defined in the Thread class. It is used to suggest to the scheduler that the current thread is willing to yield its current time slice to other threads of the same priority. By calling yield(), the current thread voluntarily gives up the CPU and allows other threads to run.

# 12. Explain thread pool
A thread pool is a managed pool of threads that can be used to execute tasks concurrently in Java. Instead of creating a new thread for every task, a thread pool reuses a fixed number of threads, resulting in better performance and resource utilization. It provides a way to control the number of concurrent threads and manages the lifecycle of threads automatically.
# 13. What is Executor Framework in Java, its different types and how to create these executors?
The Executor framework in Java provides a set of interfaces and classes that facilitate the execution of tasks asynchronously and concurrently.
1. ThreadPoolExecutor
2. ScheduledThreadPoolExecutor
3. ForkJoinPool
4. SingleThreadExecutor
```
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.execute(() -> {
    // Task 1
});

executor.execute(() -> {
    // Task 2
});
executor.shutdown();
```

# 14. Difference between shutdown() and shutdownNow() methods of executor
The shutdown() method is used to gracefully shut down an ExecutorService. It initiates an orderly shutdown by allowing previously submitted tasks to complete execution while rejecting new tasks. It does not interrupt already running tasks. 

The shutdownNow() method is used to forcefully shut down an ExecutorService. It attempts to stop all executing tasks and interrupts any currently running threads.

# 15. What is Atomic classes? when do we use it?
Atomic classes provide low-level thread-safe operations on single variables without requiring explicit synchronization. They are designed to support lock-free and thread-safe programming by ensuring atomicity and visibility of operations on shared variables.

Atomic classes are used in scenarios where multiple threads access and modify shared variables, and you want to avoid data races and ensure thread safety.

# 16. What is the cocurrent collections?
- ConcurrentHashMap
- ConcurrentLinkedQueue
- ConcurrentSkipListSet
- CopyOnWriteArrayList

# 17.  what kind of locks you know? 
- ReentrantLock
- synchronized
- ReadWriteLock
- StampedLock

# 18. What is the difference between class lock and object lock?
Class lock is associated with the class itself rather than a specific instance (object) of the class. Class locks are acquired on the class's Class object and are used to control access to class-level data or methods. Class locks are acquired and released at the class level and are shared among all instances of the class.

Object lock is associated with a specific instance of a class. Each instance of a class has its own object lock, and threads must acquire the object lock before accessing synchronized blocks or methods of that instance. Object locks provide exclusive access to instance-specific data and ensure thread safety within the context of that object.

# 19. What is future and completableFuture?
Future represents the result of an asynchronous computation. When a task is submitted to an ExecutorService, it returns a Future object that can be used to retrieve the result of the computation, block until the computation is complete, or cancel the task if needed.

CompletableFuture is a class introduced in Java 8 as an extension of Future. It enhances the capabilities of Future by providing a more flexible and powerful API for asynchronous programming. It allows chaining of multiple operations, combining multiple CompletableFuture instances.

# 20. what is ThreadLocal?
A thread-local variable is a variable that is local to each thread and is not shared among multiple threads.

# 22. Some important interview questions on multithread.
## What's the difference between User thread and Daemon thread?
User and Daemon are basically two types of thread used in Java by using a ‘Thread Class’.  

User Thread (Non-Daemon Thread): In Java, user threads have a specific life cycle and its life is independent of any other thread. JVM (Java Virtual Machine) waits for any of the user threads to complete its tasks before terminating it. When user threads are finished, JVM terminates the whole program along with associated daemon threads. 

Daemon Thread: In Java, daemon threads are basically referred to as a service provider that provides services and support to user threads. There are basically two methods available in thread class for daemon thread: setDaemon() and isDaemon(). 

## Can two threads execute two methods (static and non-static concurrently)?
Yes, it is possible. If both the threads acquire locks on different objects, then they can execute concurrently without any problem.

## How do threads communicate with each other?
Threads can communicate using three methods i.e., wait(), notify(), and notifyAll()

# 23 write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.
See details in folder Coding

# 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random
Also in coding
# Chuwa 0620 Assignment 5

### Zhizhou Xu

1. **Explain volatile variables in java?**  
   `volatile` keyword in Java allows users to declare variables that are shared among multiple threads, ensuring visibility, atomicity, and ordering of updates. It is useful when dealing with simple shared variables that require coordination between threads but do not require complex synchronization mechanisms.

2. **How to create threads?**

   ```java
   // extends from Thread
   public class MyThread extends Thread{
       @Override
       public void run(){
           // do something
       }
   }
   Thread t = new MyThread();
   t.start();

   // runnable
   public class MyRunnable implements Runnable{
       @Override
       public void run() {
           // do something
       }
   }
   Thread t2 = new Thread(new MyRunnable())

   // callable
   public class MyCallable implements Callable<String> {
       @Override
       public String call() throws Exception {
           Thread.sleep(5000);
           return "Start new thread using Callable";
       }
   }

   // Thread pool
   ExecutorService executor = Executors.newFixedThreadPool(4);
   executor.submit(task1);
   executor.submit(task2);
   executor.submit(task3);
   ```

3. **Difference between runnable and callable.**  
   `runnable` has no return value while `callable` has a `String` return value. `runnable` does not throw exceptions while `callable` throws exceptions.

4. **What is the diff between t.start() and t.run()?**  
   `t.start()` creates a new thread. `t.run()` runs the task in this thread.

5. **Which way of creating threads is better: Thread class or Runnable interface?**  
   It depends on whether you need to override more specific methods in `Thread` class. If you do not need to override more methods, then implementing `Runnable` interface would be better because it is more simple to use and you can even use lambda expressions to create a new thread because `Runnable` interface is actually a functional interface.

6. **What is thread status?**

- NEW: The thread has been created but not started yet.
- RUNNABLE: The thread is eligible to run and may be executing or waiting for CPU time.
- BLOCKED: The thread is waiting to acquire a lock to enter a synchronized block or method.
- WAITING: The thread is waiting indefinitely for another thread to perform a specific action.
- TIMED_WAITING: The thread is waiting for a specified amount of time for another thread to perform a specific action.
- TERMINATED: The thread has completed its execution or has been terminated due to an exception.

7. **Difference between wait() and sleep() method**  
   `wait()` is used for synchronization and inter-thread communication, while `sleep()` is used for introducing a delay or pause in the execution of a thread. The `wait()` method is called on an object and requires synchronization, whereas `sleep()` is a static method of the Thread class and doesn't involve synchronization directly.

8. **What is deadlock?**  
   Deadlock is a situation where threads are trapped in an eternal wait for resources, causing a system to become unresponsive.

9. **How do threads communicate with each other?**  
   Threads communicate with each other through shared memory, message passing, signaling and waiting, callbacks, and thread joining. They can share data through shared memory, send messages or signals to each other, coordinate actions through signaling mechanisms, use callbacks or event handlers, and wait for other threads to complete using the `join()` method.

10. **What is join() method?**  
    `join()` method is used to pause the current thread till the thread which called `join()` to be finished.

11. **What is yield() method?**  
    The `yield()` method is typically used in scenarios where you want to provide other threads an opportunity to execute, especially when multiple threads of similar priority are contending for CPU time. However, it's important to use `yield()` with caution and consider the specific requirements and behavior of your application, as the actual impact of yielding can vary depending on the platform, scheduler implementation, and other factors.

12. **Explain thread pool**  
    A thread pool is a managed collection of pre-initialized threads that allows for efficient execution of tasks by reusing threads, reducing overhead, and providing control over concurrency. It is a widely used technique in concurrent programming to improve performance and scalability.

13. **What is Executor Framework in Java, its different types and how to create these executors?**  
    The Executor Framework in Java provides a high-level way to manage threads and execute tasks asynchronously. It includes the following types of executors:

- ExecutorService: Executes Runnable and Callable tasks. Create it using Executors.newFixedThreadPool(int nThreads).

- ScheduledExecutorService: Extends ExecutorService and provides scheduling capabilities. Create it using Executors.newScheduledThreadPool(int corePoolSize).

- ForkJoinPool: Specialized executor for divide-and-conquer tasks. Create it using new ForkJoinPool(int parallelism).

  To create these executors, use the factory methods provided by the Executors class. After creating the executor, submit tasks for execution using methods like submit() or execute(). Remember to properly shut down the executor using shutdown() or shutdownNow().

14. **Difference between `shutdown()` and `shutdownNow()` methods of executor**  
    `shutdown()` gracefully shuts down the ExecutorService, allowing ongoing tasks to complete, while `shutdownNow()` forcefully terminates the ExecutorService, attempting to cancel executing tasks and returning pending tasks.

15. **What is Atomic classes? when do we use it?**  
    Atomic classes in Java provide thread-safe operations on single variables without explicit synchronization. They are used to ensure atomicity, improve thread safety, and increase performance in scenarios where multiple threads access and modify shared variables concurrently.

16. **What is the cocurrent collections?**  
    Cocurrent collections are thread-safe data structures provided by java.

17. **What kind of locks you know?**

- `ReentrantLock`: A flexible lock implementation that allows for reentrant locking and features like fairness and condition variables.

- `ReadWriteLock`: Provides separate locks for read and write operations, allowing multiple threads to read simultaneously while ensuring exclusive access for writing.

- `ReentrantReadWriteLock`: An implementation of `ReadWriteLock` that allows reentrant locking, providing higher concurrency for reads and exclusive access for writes.

- `StampedLock`: Introduced in Java 8, it offers optimistic locking and supports multiple readers, exclusive writers, and optimistic readers.

- `synchronized` keyword: A built-in mechanism in Java for implicit locking, using an internal monitor associated with the `synchronized` object.

18. **What is the difference between class lock and object lock?**  
    The main difference between class lock and object lock is the level at which they provide synchronization. Class lock operates at the class level, affecting all instances and static members, while object lock operates at the instance level, allowing concurrent access to different instances of a class. The class lock is acquired when synchronized static methods or blocks are executed, and the object lock is acquired when synchronized non-static methods or blocks are executed.

19. **What is future and completableFuture?**  
    `Future` and `CompletableFuture` are classes used to represent the result of asynchronous computations. While `Future` provides basic functionality for handling asynchronous tasks, `CompletableFuture` is a more advanced and powerful implementation introduced in Java 8, offering enhanced composition, chaining, and transformation capabilities for asynchronous programming.

20. **What is ThreadLocal?**  
    `ThreadLocal` provides a way to create thread-local variables, allowing each thread to have its own independent copy of the variable. It is used to provide isolation and separation of data among threads in multi-threaded applications.

21. **Type the code by your self and try to understand it.**  
    Done

22. **Read those interview questions and pick some important questions to this homework.**  
    **Use stream api to find the first even number in the list**  
     `java
    public class Main{
        public static void main(String[] args){
            List<Integer> list = Stream.of(1, 9, 4, 6, 3).collect(toList());
            int res = list.stream().filter((a) -> a % 2 != 0)
                                .findFirst()
                                .get();
            System.out.println("result is: " + res);
        }
    }
    `

23. **See details in coding folder**
24. **See details in coding folder**
